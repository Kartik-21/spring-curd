package com.kartik.curd.entity.bank;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */

@Entity
@Data
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

}
