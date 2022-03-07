package com.luciana.desafio.workshop.mapper;

import com.luciana.desafio.workshop.contact_of_customer.Person;
import com.luciana.desafio.workshop.dto.request.PersonDTO;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormate = "dd-MM-yyy")
    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
