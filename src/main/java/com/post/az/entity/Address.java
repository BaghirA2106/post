package com.post.az.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Address.TABEL_NAME)
public class Address extends CoreEntity {
    public static final String TABEL_NAME = "address";

    @Column(name = "address")
    private String address;

    @Column(name = "address_no")
    private String addressNo;

    @Column(name = "post_code")
    private String postCode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Person person;


}
