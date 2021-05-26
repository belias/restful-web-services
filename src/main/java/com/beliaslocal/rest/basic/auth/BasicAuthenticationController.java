package com.beliaslocal.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller -- handling HTTP requests
@CrossOrigin(origins="http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class BasicAuthenticationController {
    //GET
    //URI - /hello-world
    //method - "Hello World"
    //@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
//    @GetMapping(value= "/hello-world")
//    public String helloWorld(){
//        return "Hello World";
//    }
    @GetMapping("/basicauth")
    public AuthenticationBean basicAuthBean(){
        return new AuthenticationBean("You are authenticated");
    }

    // /hello-world/path-variable/belias
//    @GetMapping(path= "/hello-world/path-variable/{name}")
//    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
//        //throw new RuntimeException("Something went wrong");
//        return new HelloWorldBean(String.format("Hello World! Welcome, %s.", name));
//    }
}
