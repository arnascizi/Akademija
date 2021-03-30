package com.swedbank.itacademy.demo.server.person.services;

import com.swedbank.itacademy.demo.server.person.entities.Person;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonAlreadyExists;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person getById(long pid) throws PersonNotFoundException;

    void deleteById(long pid) throws PersonNotFoundException;

    void addPerson(Person person) throws PersonAlreadyExists;

    void updatePerson(Person person, long pid) throws PersonNotFoundException;

    public void saveAndFlush(Person person);
}
