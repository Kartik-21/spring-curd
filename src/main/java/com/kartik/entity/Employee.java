package com.kartik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kartik.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //owing side --child
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
//    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_x_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;
}
