package com.luciana.desafio.workshop.repository;

import com.luciana.desafio.workshop.contact_of_customer.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
