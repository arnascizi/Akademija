package com.swedbank.itacademy.demo.server.controllers;

import com.swedbank.itacademy.demo.server.entities.Person;
import com.swedbank.itacademy.demo.server.exceptions.PersonAlreadyExists;
import com.swedbank.itacademy.demo.server.exceptions.PersonNotFoundException;
import com.swedbank.itacademy.demo.server.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", path = "/{pid}")
    public ResponseEntity<Person> getOnePersonById(@PathVariable("pid") long pid) {
        try {
            return new ResponseEntity<>(personService.getById(pid), HttpStatus.OK);
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{pid}")
    public ResponseEntity<Person> deletePersonById(@PathVariable("pid") long pid) {
        try {
            personService.deleteById(pid);
            return ResponseEntity.ok().build();
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Void> addNewPerson(@RequestBody Person person) {
        try {
            personService.addPerson(person);
            return ResponseEntity.ok().build();
        } catch (PersonAlreadyExists ex) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(produces = "application/json", path = "/{pid}")
    public ResponseEntity<Void> updatePerson(@RequestBody Person person, @PathVariable("pid") long pid) {
        try {
            personService.updatePerson(person, pid);
            return ResponseEntity.ok().build();
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}
