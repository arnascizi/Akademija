package com.swedbank.itacademy.demo.server.group.controller;

import com.swedbank.itacademy.demo.server.group.exception.GroupExistsException;
import com.swedbank.itacademy.demo.server.group.exception.GroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GroupExceptionController {

    @ExceptionHandler(value = GroupNotFoundException.class)
    public ResponseEntity<Object> groupNotFound(GroupNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = GroupExistsException.class)
    public ResponseEntity<Object> groupExists(GroupExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
