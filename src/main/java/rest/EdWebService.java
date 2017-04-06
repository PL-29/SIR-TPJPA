package rest;

import dao.ElectronicDeviceDao;
import dao.PersonDao;
import domain.ElectronicDevice;
import domain.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
