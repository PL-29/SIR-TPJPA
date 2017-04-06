package jpa;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			test.createTheSituation();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPerson();
		test.getAllResidences();
		test.findAllHeaters();
		test.findHeaterById(1);

		manager.close();
		factory.close();
	}


	public void createTheSituation(){
		/* ------- HOME ------- */
		Collection<Home> residences1 = new ArrayList<Home>();
		Home residence2 = new Home();
		residence2.setNbRoom(6);
		residence2.setSize(150);
		residences1.add(residence2);

		Home residence3 = new Home();
		residence3.setNbRoom(25);
		residence3.setSize(1000);
		residences1.add(residence3);

		Collection<Home> residences2 = new ArrayList<Home>();
		Home residence4 = new Home();
		residence4.setNbRoom(6);
		residence4.setSize(150);
		residences2.add(residence4);



			/* ------- PERSON ------- */
		Person p1 = new Person();
		p1.setFirstname("Bodie");
		p1.setLastname("Godis");
		p1.setEmail("gb@gmail.com");
		p1.setResidences(residences1);

		Person p2 = new Person();
		p2.setFirstname("Ollivier");
		p2.setLastname("PL");
		p2.setEmail("plo@gmail.com");
		p2.setResidences(residences1);

		Person p3 = new Person();
		p3.setFirstname("Ravet");
		p3.setLastname("Antoine");
		p3.setEmail("raveta@gmail.com");
		p3.setResidences(residences2);

		Person p4 = new Person();
		p4.setFirstname("Renault");
		p4.setLastname("Alexis");
		p4.setEmail("renaulta@gmail.com");
		p4.setResidences(residences2);


			/* ------- HEATER ------- */
		Collection<Heater> heaters1 = new ArrayList<Heater>();
		Heater h1 = new Heater();
		h1.setConsomation(50);
		h1.setPower(1000);
		heaters1.add(h1);

		Collection<Heater> heaters2 = new ArrayList<Heater>();
		Heater h2 = new Heater();
		h2.setConsomation(100);
		h2.setPower(2000);
		heaters2.add(h2);

		Collection<Heater> heaters3 = new ArrayList<Heater>();
		Heater h3 = new Heater();
		h3.setConsomation(75);
		h3.setPower(1800);
		heaters3.add(h3);

		h1.setResidence(residence2);
		h2.setResidence(residence3);
		h3.setResidence(residence4);

		residence2.setHeaters(heaters1);
		residence3.setHeaters(heaters2);
		residence4.setHeaters(heaters3);



			/* ------- ED ------- */
		Collection<ElectronicDevice> electronicDevices1 = new ArrayList<ElectronicDevice>();
		ElectronicDevice ed1 = new ElectronicDevice();
		ed1.setConsomation(100);
		ed1.setFonction("Robot de cuisine");
		ed1.setResidence(residence2);

		ElectronicDevice ed2 = new ElectronicDevice();
		ed2.setConsomation(20);
		ed2.setFonction("Domotique");
		ed2.setResidence(residence2);

		Collection<ElectronicDevice> electronicDevices2 = new ArrayList<ElectronicDevice>();
		ElectronicDevice ed3 = new ElectronicDevice();
		ed3.setConsomation(250);
		ed3.setFonction("Mixeur");
		ed3.setResidence(residence3);

		ElectronicDevice ed4 = new ElectronicDevice();
		ed4.setConsomation(50);
		ed4.setFonction("Caméras");
		ed4.setResidence(residence3);

		Collection<ElectronicDevice> electronicDevices3 = new ArrayList<ElectronicDevice>();
		ElectronicDevice ed5 = new ElectronicDevice();
		ed5.setConsomation(750);
		ed5.setFonction("TV");
		ed5.setResidence(residence4);

		electronicDevices1.add(ed1);
		electronicDevices1.add(ed2);
		electronicDevices2.add(ed3);
		electronicDevices2.add(ed4);
		electronicDevices3.add(ed5);

		residence2.setElectronicDevices(electronicDevices1);
		residence3.setElectronicDevices(electronicDevices2);
		residence4.setElectronicDevices(electronicDevices3);

		manager.persist(residence2);
		manager.persist(residence3);
		manager.persist(residence4);
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(h3);
		manager.persist(ed1);
		manager.persist(ed2);
		manager.persist(ed3);
		manager.persist(ed4);
		manager.persist(ed5);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);

	}

	private void listPerson() {
		List<Person> resultList = manager.createQuery("Select p From Person p", Person.class).getResultList();
		System.out.println("num of person:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next person: " + next);
		}
	}

	public List<Person> getPersons() {
		return manager.createQuery("Select p From Person p", Person.class).getResultList();
	}

	public void getAllResidences(){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

		Root<Home> from = criteriaQuery.from(Home.class);
		CriteriaQuery<Object> select = criteriaQuery.select(from);

		TypedQuery<Object> typedQuery = manager.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();

		for(Object o : resultList){
			System.out.println("CriteriaQuery ---> ID DES RESIDENCES : "+((Home) o).getIdHome() );
		}
	}

	public void findAllHeaters(){
		List<Heater> results = manager.createNamedQuery("Heater.findAll").getResultList();
		for (Heater h : results){
			System.out.println("NamedQuery ---> CHAUFFAGE : "+h.getIdHeater());
		}
	}

	public void findHeaterById(int id){
		Object result = manager.createNamedQuery("Heater.findById")
				.setParameter("id",id)
				.getSingleResult();

		System.out.println("NamedQuery ---> CHAUFFAGE POWER : "+((Heater) result).getPower());
	}
}
