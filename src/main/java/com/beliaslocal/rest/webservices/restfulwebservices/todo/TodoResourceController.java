package com.beliaslocal.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResourceController {

    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    // add throws InterruptedException in order to get Thread.sleep(3000); to work
    public List<Todo> getAllTodos(@PathVariable String username) throws InterruptedException {
        //      Thread.sleep(3000);
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getAllTodos(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    //DELETE /users/{username}/todos/{id}
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id) {

        Todo todo = todoService.deleteById(id);

        if(todo!=null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    //Edit/Update a Todo
    //Put /users/{username}/todos/{id}
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable long id,
            @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);

        return new ResponseEntity<Todo>(todo,HttpStatus.OK);
    }

    //Create a new Todo
    //Post /users/{username}/todos/
    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String username,
            @RequestBody Todo todo) {

        Todo createdTodo = todoService.save(todo);
        //Location of the created resource
        //Get current resource url
        //{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
