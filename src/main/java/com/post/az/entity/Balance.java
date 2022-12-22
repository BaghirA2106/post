package com.post.az.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = Balance.TABLE_NAME)
public class Balance extends CoreEntity {
    public static final String TABLE_NAME = "balance";

    @Column(name = "transaction_amount")
    private String transactionAmount;


}

