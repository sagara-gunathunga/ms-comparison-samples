package sample.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.springboot.jpa.core.User;
import sample.springboot.jpa.dao.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository users;

    @RequestMapping(value = "/users/fname/{fname}/lname/{lname}", method = RequestMethod.POST)
    //TODO
    // public void addUser(HttpRequest request, HttpResponder responder, User nUser) {
    public void addUser(@PathVariable String fname, @PathVariable String lname) {

        User user = new User(fname, lname);
        users.save(user);
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable("id") long id) {
        return users.findOne(id);
    }

    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return users.findAll();
    }


}
