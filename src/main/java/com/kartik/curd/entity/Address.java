package com.kartik.curd.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String state;

    @JsonIgnore
    @OneToOne(mappedBy = "companyAddress", fetch = FetchType.LAZY, orphanRemoval = true)
    private Company company;

}
