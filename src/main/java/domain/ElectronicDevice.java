package domain;

import javax.persistence.*;

/**
 * Created by Pierre-Louis on 03/04/2017.
 */
@Entity
public class ElectronicDevice extends SmartPeripheric{
    int idElectronicDevice;
    Home residence;

    public ElectronicDevice() {
        super();
    }

    @Id
    @GeneratedValue
    @Column(name="ED_ID")
    public int getIdElectronicDevice() {
        return idElectronicDevice;
    }

    public void setIdElectronicDevice(int idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    public int getConsommation() {
        return super.getConsomation();
    }

    public void setConsommation(int consommation) { super.setConsomation(consommation); }

    @ManyToOne
    @JoinColumn(name="HOME_ED", referencedColumnName="HOME_ID")
    public Home getResidence() {
        return residence;
    }

    public void setResidence(Home residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "Device [id=" + idElectronicDevice + ", consomation =" + consomation + "]";
    }
}
