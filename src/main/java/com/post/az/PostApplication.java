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

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class PostApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }

    private final PersonRepository personRepository;

    @Transactional
    public void name(IdCard sourceIdCard, IdCard targetIdCard, String amountA) throws InterruptedException {


        int amount = Integer.valueOf(amountA);

        Person source = personRepository.findByIdCard(sourceIdCard);
        Person target = personRepository.findByIdCard(targetIdCard);

        if (amount > source.getBalance()) {
            throw new RuntimeException("insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        personRepository.updateBalance(source.getBalance(), source.getIdCard());
        Thread.sleep(10000);
        if(true){
            throw new RuntimeException();
        }
        personRepository.updateBalance(target.getBalance(), target.getIdCard());

        System.out.println(source.getBalance());
        System.out.println(target.getBalance());


    }


    @Override
    public void run(String... args) throws Exception {

        IdCard source = new IdCard();
        source.setPin("abcde");

        IdCard target = new IdCard();
        target.setPin("12345");

        name(source, target, "10");

    }
}
