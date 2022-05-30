package com.kartik.curd.entity;

import com.kartik.curd.config.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    public Integer getCompanyRank() {
        return companyRank;
    }

    public void setCompanyRank(Integer companyRank) {
        this.companyRank = companyRank;
    }

    private String firstName;

    private Integer companyRank;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;


    ///TODO: based on action we can define the cascade type
//    @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_address_id")
    private Address companyAddress;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Employee> employeeList = new ArrayList<>();

    public Company(String companyName,String firstName,String lastName,Integer companyRank) {
        this.companyName = companyName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.companyRank=companyRank;
    }

    ///for bidirectional mapping
    public void setCompanyAddress(Address companyAddress) {
        companyAddress.setCompany(this);
        this.companyAddress = companyAddress;
    }


    ///TODO: for directional mapping add
    public void addEmp(Employee employee) {
        employeeList.add(employee);
        employee.setCompany(this);
    }


    ///TODO: for directional mapping remove
    public void removeEmp(Employee employee) {
        employeeList.remove(employee);
        employee.setCompany(null);
    }

    public void setEmployeeList(List<Employee> employeeList) {
        employeeList.forEach(employee -> employee.setCompany(this));
        this.employeeList = employeeList;
    }
}
