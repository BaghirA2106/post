package com.post.az.entity;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = IdCard.TABLE_NAME)
public class IdCard {

    public static final String TABLE_NAME = "id_card";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;


    @Column(name = "pin")
    @PrimaryKeyJoinColumn
    private String pin;


}
