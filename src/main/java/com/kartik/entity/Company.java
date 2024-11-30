package com.kartik.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kartik.config.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
public class Company extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String firstName;

    private Integer companyRank;

    private String lastName;


    /// TODO: based on action we can define the cascade type
//    @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employees;

    /// for bidirectional mapping
    public void setAddress(Address address) {
        address.setCompany(this);
        this.address = address;
    }


    /// TODO: for directional mapping add
    public void addEmp(Employee employee) {
        if (employees == null)
            employees = new ArrayList<>();

        employee.setCompany(this);
        employees.add(employee);
    }


    /// TODO: for directional mapping remove
    public void removeEmp(Employee employee) {
        employee.setCompany(null);
        employees.remove(employee);
    }

    public void setEmployees(List<Employee> employees) {
        employees.forEach(employee -> employee.setCompany(this));
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", companyRank=" + companyRank +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
