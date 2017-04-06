package rest;

import dao.PersonDao;
import domain.Person;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
@Path("/person")
public class PersonWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return PersonDao.getPersons();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") int id) {
        return PersonDao.getPersonById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createPerson(String jsonStringPerson) {
        JSONObject jsonPerson = new JSONObject(jsonStringPerson);
        Person person = new Person();
        person.setFirstname(jsonPerson.getString("firstname"));
        person.setLastname(jsonPerson.getString("lastname"));
        person.setEmail(jsonPerson.getString("email"));
        return PersonDao.createPerson(person);
    }
}
