package com.swedbank.itacademy.demo.server.person.controller;

import com.swedbank.itacademy.demo.server.group.entities.Group;
import com.swedbank.itacademy.demo.server.group.exception.GroupNotFoundException;
import com.swedbank.itacademy.demo.server.group.services.GroupService;
import com.swedbank.itacademy.demo.server.person.entities.Person;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonNotFoundException;
import com.swedbank.itacademy.demo.server.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    private PersonService personService;
    private GroupService groupService;

    @Autowired
    public PersonController(PersonService personService, GroupService groupService) {
        this.personService = personService;
        this.groupService = groupService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping(produces = "application/json", path = "/{pid}")
    public ResponseEntity<Person> getOnePersonById(@PathVariable("pid") long pid) {
        return new ResponseEntity<>(personService.getById(pid), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{pid}")
    public ResponseEntity<Person> deletePersonById(@PathVariable("pid") long pid) {
        personService.deleteById(pid);
        return ResponseEntity.ok().build();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Void> addNewPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = "application/json", path = "/{pid}")
    public ResponseEntity<Void> updatePerson(@RequestBody Person person, @PathVariable("pid") long pid) {
        personService.updatePerson(person, pid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{pid}/groups")
    public ResponseEntity<Collection<Group>> getPersonGroups(@PathVariable("pid") Long pid) {

        try {
            Person person = personService.getById(pid);
            return new ResponseEntity<>(person.getGroups(), HttpStatus.OK);
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("{pid}/groups/{id}")
    public ResponseEntity<?> setGroup(@PathVariable("pid") long pid, @PathVariable("id") long id) {

        try {
            Person person = personService.getById(pid);
            Group group = groupService.findById(id);
            Set<Group> groups = person.getGroups();
            groups.add(group);
            person.setGroups(groups);
            personService.saveAndFlush(person);
            return ResponseEntity.ok().build();
        } catch (GroupNotFoundException | PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{pid}/groups/{id}")
    public ResponseEntity<?> removeFromGroup(@PathVariable("pid") long pid, @PathVariable("id") long id) {
        try {
            Person person = personService.getById(pid);
            Group group = groupService.findById(id);
            Set<Group> groups = person.getGroups();
            if (groups.contains(group)) {
                groups.remove(group);
                person.setGroups(groups);
                personService.saveAndFlush(person);
            }

            return ResponseEntity.ok().build();
        } catch (GroupNotFoundException | PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
