package com.luciana.desafio.workshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNofFoundException extends Exception {
    public PersonNofFoundException(Long id) {
        super("Person not found with ID " + id);
    }
}
