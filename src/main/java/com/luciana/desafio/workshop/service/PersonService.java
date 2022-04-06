package com.luciana.desafio.workshop.service;

import ch.qos.logback.core.util.PropertySetterException;
import com.luciana.desafio.workshop.contact_of_customer.Person;
import com.luciana.desafio.workshop.dto.mapper.PersonMapper;
import com.luciana.desafio.workshop.dto.request.PersonDTO;
import com.luciana.desafio.workshop.dto.response.MessageResponseDTO;
import com.luciana.desafio.workshop.exception.PersonNofFoundException;
import com.luciana.desafio.workshop.repository.PersonRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Create person with ID " +  savedPerson);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNofFoundException {
        Person person = verifyExixts(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNofFoundException {
        verifyExixts(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNofFoundException {
        verifyExixts(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyExixts(Long id) throws PersonNofFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNofFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
