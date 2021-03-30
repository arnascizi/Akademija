package com.swedbank.itacademy.demo.server.person.exceptions;

public class PersonAlreadyExists extends RuntimeException {

    public PersonAlreadyExists(long pid) {
        super("Person with pid: " + pid + " already exists");
    }
}
