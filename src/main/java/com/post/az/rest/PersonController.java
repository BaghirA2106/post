package com.post.az.rest;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import com.post.az.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("create/")
    public ResponseEntity<PersonDTO> createPerson (@RequestBody PersonDTO person){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
    }
}
