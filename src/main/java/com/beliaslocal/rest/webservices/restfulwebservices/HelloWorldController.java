package com.beliaslocal.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.*;

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

    // /hello-world/path-variable/belias
    @GetMapping(path= "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World! Welcome, %s.", name));
    }
}
