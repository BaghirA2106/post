package com.post.az.entity;


import javax.persistence.*;

@MappedSuperclass
public class CoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

    @Column(name = "state")
    private Byte state;

    public static final Byte ACTIVE = new Byte((byte) 1);
    public static final Byte PASSIVE = new Byte((byte) 0);
}
