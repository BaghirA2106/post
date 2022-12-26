package com.post.az.service.impl;

import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import com.post.az.entity.TransactionData;
import com.post.az.repository.TransactionDataRepository;
import com.post.az.repository.PersonRepository;
import com.post.az.service.TransactionDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionDataServiceImpl implements TransactionDataService {


    private final PersonRepository personRepository;
    private final TransactionDataRepository transactionDataRepository;


    @Override
    public TransactionData send(IdCard sourceIdCard, IdCard targetIdCard, String amountA) {

        log.info("------------------1--------------------- ");
        int amount = Integer.valueOf(amountA);
        log.info("------------------2--------------------- ");
        Person source = personRepository.findByIdCard(sourceIdCard);
        Person target = personRepository.findByIdCard(targetIdCard);

        if (amount > source.getBalance()) {
            throw new RuntimeException("insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        personRepository.updateBalance(source.getBalance(), source.getIdCard());
        personRepository.updateBalance(target.getBalance(), target.getIdCard());


        return null;
    }
}
