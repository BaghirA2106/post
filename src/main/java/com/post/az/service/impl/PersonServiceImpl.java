package com.post.az.service.impl;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import com.post.az.repository.PersonRepository;
import com.post.az.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final ModelMapper modelMapper;
    private final PersonRepository personRepository;

    @Override
    public PersonDTO create(PersonDTO person) {
        Person create = modelMapper.map(person, Person.class);
        return modelMapper.map(personRepository.save(create), PersonDTO.class);
    }

    @Cacheable(value = "persons")
    @Override
    public List<PersonDTO> getAllPerson() {
        List<Person> all = personRepository.findAll();
        List<PersonDTO> dto = all
                .stream()
                .map(user -> modelMapper.map(user, PersonDTO.class))
                .collect(Collectors.toList());
        return dto;
    }
//
    @CachePut(value = "persons", key = "#id")
    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(personDTO.getName() == null ? person.getName() : personDTO.getName());
                    person.setSurname(personDTO.getSurname() == null ? person.getSurname() : personDTO.getSurname());
                    person.setAge(personDTO.getAge() == null ? person.getAge() : personDTO.getAge());

                    modelMapper.map(personDTO, person);
                    return modelMapper.map(personRepository.save(person), PersonDTO.class);
                })
                .orElseThrow(() -> new RuntimeException());
    }

    @CacheEvict(value = "person")
    @Override
    public void delete(Long id) {
        Person deleteUser = personRepository.findById(id).get();
        personRepository.delete(deleteUser);
    }


}
