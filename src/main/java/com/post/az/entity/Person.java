package com.post.az.entity;

import lombok.*;

import javax.persistence.*;

import static com.post.az.entity.Person.TABLE_NAME;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TABLE_NAME)
public class Person {

    public static final String TABLE_NAME = "person";

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    private String surname;

    @Column(name = "age")
    private String age;


}
