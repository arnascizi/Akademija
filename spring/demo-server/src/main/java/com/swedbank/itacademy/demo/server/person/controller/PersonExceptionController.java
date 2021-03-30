package com.swedbank.itacademy.demo.server.person.controller;

import com.swedbank.itacademy.demo.server.person.exceptions.PersonAlreadyExists;
import com.swedbank.itacademy.demo.server.person.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<Object> personNotFound(PersonNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PersonAlreadyExists.class)
    public ResponseEntity<Object> personExist(PersonAlreadyExists exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}



