package com.kartik.controller;

import com.kartik.entity.Address;
import com.kartik.entity.Company;
import com.kartik.entity.Employee;
import com.kartik.service.CompanyManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class CompanyManagementController {

    private final CompanyManagementService service;

    @Autowired
    public CompanyManagementController(CompanyManagementService service) {
        this.service = service;
    }

    @PostMapping("/company/")
    ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return service.addCompany(company);
    }

    @PutMapping("/company/{id}/")
    ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return service.updateCompany(id, company);
    }

    @GetMapping("/company/{id}/")
    ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
        return service.getCompany(id);
    }

    @DeleteMapping("address/{id}/")
    ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        return service.deleteAddress(id);
    }

    @PostMapping("address/")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return service.addAddress(address);
    }

    @DeleteMapping("/company/{id}/")
    ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
        return service.deleteCompany(id);
    }

    @PostMapping("/employee/")
    ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
        return service.addEmp(employee);
    }


    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmp(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        return service.updateEmp(id, employee);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<Employee> getEmp(@PathVariable(name = "id") Long id) {
        return service.getEmp(id);
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<Employee> deleteEmp(@PathVariable(name = "id") Long id) {
        return service.deleteEmp(id);
    }

}
