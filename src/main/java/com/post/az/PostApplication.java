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
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
@Slf4j
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);
    }
//
//    private final PersonRepository personRepository;
//    private final EntityManagerFactory entityManagerFactory;
//
//
//    public void nameTransactional(IdCard sourceIdCard, IdCard targetIdCard, int amount){
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        try{
//
//            name(sourceIdCard, targetIdCard, amount);
//            log.info("THERE ARE NOT ANY ERROR");
//            entityTransaction.commit();
//
//        } catch (RuntimeException e) {
//
////            entityTransaction.rollback();
//            log.info("TRANSACTION ALREADY {} ");
//            throw new RuntimeException(e);
//
//        }finally {
////            entityManager.flush();
//            entityManager.close();
//        }
//    }
//
//
//    @Transactional
//    public void name(IdCard sourceIdCard, IdCard targetIdCard, int amount) throws RuntimeException {
//
//
//        Person source = personRepository.findByIdCard(sourceIdCard);
//        Person target = personRepository.findByIdCard(targetIdCard);
//
//        if (amount > source.getBalance()) {
//            throw new RuntimeException("insufficient balance");
//        }
//        source.setBalance(source.getBalance() - amount);
//        target.setBalance(target.getBalance() + amount);
//
//        personRepository.updateBalance(source.getBalance(), source.getIdCard());
//        personRepository.updateBalance(target.getBalance(), target.getIdCard());
//        if (true) {
//            throw new RuntimeException("Unchecked exception has been thrown");
//        }
//
//        System.out.println(source.getBalance());
//        System.out.println(target.getBalance());
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        IdCard source = new IdCard();
//        source.setPin("abcde");
//
//        IdCard target = new IdCard();
//        target.setPin("12345");
//
//        nameTransactional(source, target, 10);
//
//    }
}
