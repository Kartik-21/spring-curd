package com.kartik.curd.entity.bank;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */


/*
 *
 * UNI DIRECTIONAL MAPPING
 *
 * */
@Entity
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Bank> banks;

}
