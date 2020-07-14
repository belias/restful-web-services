package com.beliaslocal.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller -- handling HTTP requests
@RestController
public class HelloWorldController {


    //GET
    //URI - /hello-world
    //method - "Hello World"
    //@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    @GetMapping(value = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

}
