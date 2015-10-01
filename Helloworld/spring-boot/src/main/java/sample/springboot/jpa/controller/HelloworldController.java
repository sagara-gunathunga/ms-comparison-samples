package sample.springboot.jpa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @RequestMapping(value = "hello/{user}", produces = "application/json")
    public String String(@PathVariable String user) {
        return "Hello " + user;
    }
}
