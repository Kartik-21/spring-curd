package com.kartik.curd.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Transient
    private String pri;

    @Embedded
    private Owner owner;

}


