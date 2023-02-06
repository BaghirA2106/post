package com.post.az.service;

import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import com.post.az.entity.TransactionData;

import java.util.List;

public interface TransactionDataService {

    TransactionData send (IdCard source, IdCard target, String amount) throws InterruptedException;
}
