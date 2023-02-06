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

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TransactionDataServiceImpl implements TransactionDataService {


    private final PersonRepository personRepository;
    private final TransactionDataRepository transactionDataRepository;


    @Override
    @Transactional
    public TransactionData send(IdCard sourceIdCard, IdCard targetIdCard, String amountA) throws InterruptedException {

        log.info("Begin send method");
        int amount = Integer.parseInt(amountA);

//        IdCard sourceIdCard = accounts.get(0);
//        IdCard targetIdCard = accounts.get(1);


        Person source = personRepository.findByIdCard(sourceIdCard);
        Person target = personRepository.findByIdCard(targetIdCard);

        if (amount > source.getBalance()) {
            throw new RuntimeException("insufficient balance");
        }

//        Thread.sleep(15000);
        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        personRepository.updateBalance(source.getBalance(), source.getIdCard());
        personRepository.updateBalance(target.getBalance(), target.getIdCard());

        TransactionData transactionData = new TransactionData();
        transactionData.setSourceAcc(source.getIdCard().getPin());
        transactionData.setTargetAcc(target.getIdCard().getPin());
        transactionData.setTransactionAmount(amountA);


        return transactionDataRepository.save(transactionData);
    }
}
