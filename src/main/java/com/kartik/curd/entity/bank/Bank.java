package com.kartik.curd.entity.bank;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bank_company",
            joinColumns = @JoinColumn(name = "bank_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<CompanyBusiness> companies;
}
