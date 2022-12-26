package com.post.az.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import static com.post.az.entity.Person.TABLE_NAME;

@NamedEntityGraph(name = "Person.address",
        attributeNodes = {
                @NamedAttributeNode("address")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TABLE_NAME)
public class Person extends CoreEntity {

    public static final String TABLE_NAME = "person";

    @Column(name = "name")
    private String name;

    private String surname;

    @Column(name = "age")
    private String age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pin", referencedColumnName = "pin")
    private IdCard idCard;


    @Column(name = "balance")
    private Long balance;
}
