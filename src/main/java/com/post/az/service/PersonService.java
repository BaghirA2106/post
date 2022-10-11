package com.post.az.service;

import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    PersonDTO create (Person person);
}
