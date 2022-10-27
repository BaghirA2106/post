package com.post.az;

import com.post.az.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//         personRepository.getData("Baghir").stream().map(person -> person).forEach(System.out::println);
//        personRepository.updatePersonName("Baghir", 1L);

    }
}
