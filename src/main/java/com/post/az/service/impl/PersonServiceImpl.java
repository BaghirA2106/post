package com.post.az.service.impl;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import com.post.az.mapper.PersonMapper;
import com.post.az.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private PersonMapper personMapper;

    @Override
    public PersonDTO create(Person person) {
        return null;
    }
}
