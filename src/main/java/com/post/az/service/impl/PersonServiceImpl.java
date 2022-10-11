package com.post.az.service.impl;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import com.post.az.mapper.PersonMapper;
import com.post.az.repository.PersonRepository;
import com.post.az.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
