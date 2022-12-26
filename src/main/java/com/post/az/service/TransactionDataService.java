package com.post.az.service;

import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import com.post.az.entity.TransactionData;

public interface TransactionDataService {

    TransactionData send (IdCard sourceIdCard, IdCard targetIdCard, String amount);
}
