package com.kartik.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kartik.config.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String state;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonBackReference
    private Company company;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
