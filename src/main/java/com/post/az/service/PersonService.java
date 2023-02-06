package com.post.az.service;

import com.post.az.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO create (PersonDTO dto);

    List<PersonDTO> getAllPerson();

    PersonDTO updatePerson(Long id, PersonDTO personDTO);

    void delete (Long id);

    PersonDTO getPersonById(Long id);
}
