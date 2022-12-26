package com.post.az.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = TransactionData.TABLE_NAME)
public class TransactionData extends CoreEntity {
    public static final String TABLE_NAME = "balance";

    @Column(name = "transaction_amount")
    private String transactionAmount;

    @Column(name = "source_account")
    private String sourceAcc;

    @Column(name = "target_Account")
    private String targetAcc;

}

