package sample.dropwizard.jpa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloworldResource {

    @GET
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("user") String user) {
        return "Hello " + user;
    }

}
