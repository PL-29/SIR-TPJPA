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
		Collection<Home> residences = new ArrayList<Home>();
		Home residence = new Home();
		residence.setNbRoom(5);
		residence.setSize(1000);
		residences.add(residence);

			/* ------- PERSON ------- */
		Person p1 = new Person();
		p1.setFirstname("Godis");
		p1.setLastname("Bodie");
		p1.setEmail("gb@gmail.com");
		p1.setResidences(residences);
		Person p2 = new Person();
		p2.setFirstname("PL");
		p2.setLastname("Ollivier");
		p2.setEmail("plo@gmail.com");
		p2.setResidences(residences);


			/* ------- HEATER ------- */
		Collection<Heater> heaters = new ArrayList<Heater>();
		Heater h1 = new Heater();
		h1.setConsomation(50);
		h1.setPower(1000);
		Heater h2 = new Heater();
		h2.setConsomation(100);
		h2.setPower(2000);
		heaters.add(h1);
		heaters.add(h2);
		h1.setResidence(residence);
		h2.setResidence(residence);
		residence.setHeaters(heaters);



			/* ------- ED ------- */
		Collection<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();
		ElectronicDevice ed1 = new ElectronicDevice();
		ed1.setConsomation(100);
		ElectronicDevice ed2 = new ElectronicDevice();
		ed2.setConsomation(20);
		electronicDevices.add(ed1);
		electronicDevices.add(ed2);



		ed1.setResidence(residence);
		ed2.setResidence(residence);
		residence.setElectronicDevices(electronicDevices);

		manager.persist(residence);
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(ed1);
		manager.persist(ed2);
		manager.persist(p1);
		manager.persist(p2);

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
