package dao;

import domain.ElectronicDevice;
import domain.Heater;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
public class ElectronicDeviceDao {
    public static List<ElectronicDevice> getHeaters(){
        return Manager.getManagerInstance().createQuery("Select e From ElectronicDevice e", ElectronicDevice.class).getResultList();
    }

    public static ElectronicDevice getHeaterById(int id){
        return Manager.getManagerInstance().createQuery("Select e From ElectronicDevice e where e.id=:id", ElectronicDevice.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public static Boolean createElectronicDevice(ElectronicDevice ed){
        EntityTransaction tx = Manager.getManagerInstance().getTransaction();
        tx.begin();
        try {
            Manager.getManagerInstance().persist(ed);
        } catch (Exception e) {
            return false;
        }
        tx.commit();
        return true;
    }
}
