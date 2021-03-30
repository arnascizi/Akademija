package com.swedbank.itacademy.demo.server.person.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(long pid) {
        super("Can't find person with pid: " + pid);
    }
}
