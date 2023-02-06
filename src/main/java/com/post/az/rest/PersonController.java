package com.post.az.rest;


import com.post.az.dto.PersonDTO;
import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import com.post.az.entity.TransactionData;
import com.post.az.service.PersonService;
import com.post.az.service.TransactionDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;
    private final TransactionDataService transactionDataService;

    @PostMapping("create/")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person));
    }

    @GetMapping("persons/")
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @GetMapping("person/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("update/{id}/")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(id, personDTO));
    }

    @DeleteMapping("delete/{id}/")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }

    @PostMapping("update/{source}/{target}/{amount}/")
    public TransactionData sendMoney(
            @PathVariable IdCard source,
            @PathVariable IdCard target,
            @PathVariable String amount) throws InterruptedException {
        log.info("Start");
        return transactionDataService.send(source, target, amount);
    }
}
