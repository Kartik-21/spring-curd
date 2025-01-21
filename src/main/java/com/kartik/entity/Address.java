package com.kartik.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kartik.config.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Address extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String state;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Company company;

    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore
    private List<Employee> employees;
}
