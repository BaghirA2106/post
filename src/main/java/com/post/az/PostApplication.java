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
    private final AddressRepository addressRepository;
    private final CarRepository carRepository;
    private final IdCardRepository idCardRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Person> getSpecificPerson = personRepository.getPersonByAgeGreaterThanTwenty("1");
        personRepository.getData("Baghir").stream().map(person -> person).forEach(System.out::println);
        personRepository.getALlDAta().stream().forEach(System.out::println);
        personRepository.getALlDAta().stream().forEach(System.out::println);
        for (int i = 2; i < 200; i++) {
            Person person = Person.builder()
                    .name("Name-" + i)
                    .surname("Surname-" + i)
                    .age("" + i)
                    .build();

            Address address = Address.builder()
                    .addressNo("addressNo-" + i)
                    .address("address-" + i)
                    .postCode("" + (i * 10))
                    .build();
            address.setPerson(person);
            person.setAddress(address);
            addressRepository.save(address);

            Car car = Car.builder()
                    .id((long) i)
                    .model("model-" + i)
                    .carIdNo((i + 2) + " AA " + i)
                    .brandName("brandName-" + i)
                    .personId(person)
                    .build();
            car.setPersonId(person);
            carRepository.save(car);

            IdCard idCard = IdCard.builder()
                    .pin("6W4hE" + i)
                    .serialNumber((i * 896) + "")
                    .build();
            person.setIdCard(idCard);
            idCardRepository.save(idCard);

//            person.setIdCard(idCard);
//            person.setAddress(address);
            personRepository.save(person);
//            address.setPerson(person);
//            car.setPersonId(person);

//            carRepository.save(car);
//            idCardRepository.save(idCard);
//            addressRepository.save(address);
        }


    }
}
