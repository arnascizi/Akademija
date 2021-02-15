package com.swedbank.itacademy.demo.server.services;

import com.swedbank.itacademy.demo.server.entities.Person;
import com.swedbank.itacademy.demo.server.exceptions.PersonAlreadyExists;
import com.swedbank.itacademy.demo.server.exceptions.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person getById(long pid) throws PersonNotFoundException;

    void deleteById(long pid) throws PersonNotFoundException;

    void addPerson(Person person) throws PersonAlreadyExists;

    void updatePerson(Person person, long pid) throws PersonNotFoundException;
}
