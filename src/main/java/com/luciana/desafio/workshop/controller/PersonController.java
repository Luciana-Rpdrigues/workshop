package com.luciana.desafio.workshop.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // aplicações
@RequestMapping //("/api/v1/people")
public class PersonController {

    @GetMapping
    public String getVeiculo() {
        return "Commit";
    }
}