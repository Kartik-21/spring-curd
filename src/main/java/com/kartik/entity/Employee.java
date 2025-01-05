package com.kartik.entity;

import com.kartik.config.AuditModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "company_id")
////    @JsonBackReference
//    private Company company;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private Address address;
}
