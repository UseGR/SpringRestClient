package ru.galeev.springcourse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.galeev.springcourse.Communication;
import ru.galeev.springcourse.models.Person;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private final Communication communication;

    public MainController(Communication communication) {
        this.communication = communication;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Person>> getPeople() {
        List<Person> people = communication.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        return new ResponseEntity<>(communication.getPersonById(id), HttpStatus.OK);
    }
}
