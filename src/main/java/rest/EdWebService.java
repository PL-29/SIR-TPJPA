package rest;

import dao.ElectronicDeviceDao;
import dao.HeaterDao;
import dao.PersonDao;
import domain.ElectronicDevice;
import domain.Heater;
import domain.Person;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
@Path("/electronicdevice")
public class EdWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ElectronicDevice> getAllPersons() {
        return ElectronicDeviceDao.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public ElectronicDevice findById(@PathParam("id") int id) {
        return ElectronicDeviceDao.getHeaterById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createEd(String jsonStringEd) {
        JSONObject jsonEd = new JSONObject(jsonStringEd);
        ElectronicDevice ed = new ElectronicDevice();
        ed.setConsomation(jsonEd.getInt("consomation"));
        ed.setFonction(jsonEd.getString("fonction"));
        return ElectronicDeviceDao.createElectronicDevice(ed);
    }
}
