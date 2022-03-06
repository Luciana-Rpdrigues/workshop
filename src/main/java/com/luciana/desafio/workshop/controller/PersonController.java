package com.luciana.desafio.workshop.controller;

import com.luciana.desafio.workshop.contact_of_customer.Person;
import com.luciana.desafio.workshop.dto.response.MessageResponseDTO;
import com.luciana.desafio.workshop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController // aplicações
@RequestMapping ("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository workshopRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public MessageResponseDTO createWorkshop(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message(("Create person withj ID " + savedPerson.getId()))
                .build();
    }
}