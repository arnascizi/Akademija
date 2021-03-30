package com.swedbank.itacademy.demo.server.person.services;

import com.swedbank.itacademy.demo.server.person.entities.Person;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonAlreadyExists;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonNotFoundException;
import com.swedbank.itacademy.demo.server.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(long pid) throws PersonNotFoundException {
        return personRepository.findById(pid).orElseThrow(() ->
                new PersonNotFoundException(pid));
    }

    @Override
    public void deleteById(long pid) throws PersonNotFoundException {
        personRepository.findById(pid).orElseThrow(() ->
                new PersonNotFoundException(pid));
        personRepository.deleteById(pid);
    }

    @Override
    public void addPerson(Person person) throws PersonAlreadyExists {
        if (personRepository.existsById(person.getPid())) {
            throw new PersonAlreadyExists(person.getPid());
        } else {
            personRepository.save(person);
        }
    }

    @Override
    public void updatePerson(Person person, long pid) throws PersonNotFoundException {
        personRepository.findById(pid).orElseThrow(() ->
                new PersonNotFoundException(pid));
        personRepository.deleteById(pid);
        personRepository.save(person);
    }


    @Override
    public void saveAndFlush(Person person) {
        personRepository.saveAndFlush(person);

    }
}
