package com.post.az.entity;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Car.TABLE_NAME)
public class Car {
    public static final String TABLE_NAME = "Car";

    @Id
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "model")
    private String model;

    @Column(name ="vehicle_name")
    private String vehicleName;

    @Column(name = "car_id_no")
    private String carIdNo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_person_id")
    @Fetch(FetchMode.SUBSELECT)
    private Person personId;



}
