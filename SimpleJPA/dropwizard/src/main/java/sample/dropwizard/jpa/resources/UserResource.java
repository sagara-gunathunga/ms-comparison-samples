package sample.dropwizard.jpa.resources;

import io.dropwizard.hibernate.UnitOfWork;
import sample.dropwizard.jpa.db.UserDAO;
import sample.dropwizard.jpa.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    private UserDAO users;

    public UserResource(UserDAO users) {
        this.users = users;
    }

    @POST
    @Path("/fname/{fname}/lname/{lname}")
    @UnitOfWork
    //TODO
    // public void addUser(HttpRequest request, HttpResponder responder, User nUser) {
    public Response addUser(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        User user = new User(fname, lname);
        users.create(user);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response getUser(@PathParam("id") long id) {
        User user = users.findUser(id).get();
        if (user != null) {
            return Response.status(Response.Status.ACCEPTED).entity(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response getUsers() {
        return Response.status(Response.Status.ACCEPTED).entity(users.findUsers()).build();
    }
}
