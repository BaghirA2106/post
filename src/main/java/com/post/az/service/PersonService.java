package com.post.az.service;

import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface PersonService {

    PersonDTO create (PersonDTO dto);
}
