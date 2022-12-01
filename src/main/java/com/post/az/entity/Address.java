package com.post.az.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Address.TABEL_NAME)
public class Address {
    public static final String TABEL_NAME = "address";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "address_no")
    private String addressNo;

    @Column(name = "post_code")
    private String postCode;

    @OneToOne(mappedBy = "address")
    private Person person;


}
