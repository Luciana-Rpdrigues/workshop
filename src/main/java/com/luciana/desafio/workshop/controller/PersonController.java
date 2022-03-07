package com.luciana.desafio.workshop.controller;

import com.luciana.desafio.workshop.contact_of_customer.Person;
import com.luciana.desafio.workshop.dto.response.MessageResponseDTO;
import com.luciana.desafio.workshop.repository.PersonRepository;
import com.luciana.desafio.workshop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController // aplicações
@RequestMapping //("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}