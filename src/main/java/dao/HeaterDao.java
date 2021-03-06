package dao;

import domain.Heater;
import domain.Home;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
public class HeaterDao {
    public static List<Heater> getHeaters(){
        return Manager.getManagerInstance().createQuery("Select h From Heater h", Heater.class).getResultList();
    }

    public static Heater getHeaterById(int id){
        return Manager.getManagerInstance().createQuery("Select h From Heater h where h.id=:id", Heater.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public static Boolean createHeater(Heater heater){
        EntityTransaction tx = Manager.getManagerInstance().getTransaction();
        tx.begin();
        try {
            Manager.getManagerInstance().persist(heater);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
}
