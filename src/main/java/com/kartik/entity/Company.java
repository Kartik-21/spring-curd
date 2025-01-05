package com.kartik.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kartik.config.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Company extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;


//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Employee> employees;

    /// for bidirectional mapping
//    public void setAddress(Address address) {
//        address.setCompany(this);
//        this.address = address;
//    }


    /// TODO: for directional mapping add
//    public void addEmp(Employee employee) {
//        if (employees == null)
//            employees = new ArrayList<>();
//
//        employee.setCompany(this);
//        employees.add(employee);
//    }


//    /// TODO: for directional mapping remove
//    public void removeEmp(Employee employee) {
//        employee.setCompany(null);
//        employees.remove(employee);
//    }

//    public void setEmployees(List<Employee> employees) {
//        employees.forEach(employee -> employee.setCompany(this));
//        this.employees = employees;
//    }
}
