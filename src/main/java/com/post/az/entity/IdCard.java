package com.post.az.entity;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = IdCard.TABLE_NAME)
public class IdCard extends CoreEntity implements Serializable {

    public static final String TABLE_NAME = "id_card";

    @Column(name = "serial_number")
    private String serialNumber;


    @Column(name = "pin")
    @PrimaryKeyJoinColumn
    private String pin;


}
