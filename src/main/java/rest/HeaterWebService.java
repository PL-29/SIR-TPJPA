package rest;

import dao.HeaterDao;
import dao.HomeDao;
import domain.Heater;
import domain.Home;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
@Path("/heater")
public class HeaterWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Heater> getAllHomes() {
        return HeaterDao.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Heater findById(@PathParam("id") int id) {
        return HeaterDao.getHeaterById(id);
    }
}
