package com.post.az;

import com.post.az.entity.Address;
import com.post.az.entity.Car;
import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import com.post.az.repository.AddressRepository;
import com.post.az.repository.CarRepository;
import com.post.az.repository.IdCardRepository;
import com.post.az.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class PostApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
//        List<Person> getSpecificPerson = personRepository.getPersonByAgeGreaterThanTwenty("1");
//        personRepository.getData("Baghir").stream().map(person -> person).forEach(System.out::println);
//        personRepository.getALlDAta().stream().forEach(System.out::println);
        personRepository.getALlDAta().stream().forEach(System.out::println);

    }
}
