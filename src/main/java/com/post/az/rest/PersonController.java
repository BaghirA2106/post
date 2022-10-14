package com.post.az.rest;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import com.post.az.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("create/")
    public ResponseEntity<PersonDTO> createPerson (@RequestBody PersonDTO person){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
    }

    @GetMapping("persons/")
    public ResponseEntity<List<PersonDTO>> getAllPerson (){
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PatchMapping("update/{id}/")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.updatePerson(id,personDTO));
    }

    @DeleteMapping("delete/{id}/")
    public void deletePerson (@PathVariable Long id){
        personService.delete(id);
    }
}
