package com.kartik.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Address implements Serializable/*extends AuditModel */ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String state;

    @OneToOne(mappedBy = "address")
//    @JsonBackReference
    private Employee company;
}
