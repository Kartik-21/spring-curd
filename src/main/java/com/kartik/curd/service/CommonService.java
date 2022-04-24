package com.kartik.curd.service;

import com.kartik.curd.entity.Address;
import com.kartik.curd.entity.Company;
import com.kartik.curd.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface CommonService {

    ResponseEntity<Company> addCompany(Company company);

    ResponseEntity<Company> updateCompany(Long id,Company company);

    ResponseEntity<Address> deleteAddress(Long id);

    ResponseEntity<Company> deleteCompany(Long id);

    ResponseEntity<Employee> addEmp(Employee employee);

    ResponseEntity<Employee> updateEmp(Long id, Employee employee);

    ResponseEntity<Address> addAddress(Address address);

    ResponseEntity<Company> getCompany(Long id);

    ResponseEntity<Employee> getEmp(Long id);

    ResponseEntity<Employee> deleteEmp(Long id);
}
