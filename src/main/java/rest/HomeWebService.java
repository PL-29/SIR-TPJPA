package rest;

import dao.HomeDao;
import dao.PersonDao;
import domain.Home;
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
@Path("/home")
public class HomeWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Home> getAllHomes() {
        return HomeDao.getHomes();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Home findById(@PathParam("id") int id) {
        return HomeDao.getHomeById(id);
    }
}

