package com.kartik.controller;

import com.kartik.entity.Address;
import com.kartik.entity.Company;
import com.kartik.entity.Employee;
import com.kartik.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/company/{id}")
    ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
        return ResponseEntity.ok(companyService.companyDetails(id));
    }

    @PostMapping("/company")
    ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PutMapping("/company/{id}")
    ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/company/{id}")
    ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
        return companyService.deleteCompany(id);
    }


    @PostMapping("/address")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return companyService.addAddress(address);
    }

    @DeleteMapping("/address/{id}")
    ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        return companyService.deleteAddress(id);
    }


    @GetMapping("/employee/{id}")
    ResponseEntity<Employee> getEmp(@PathVariable(name = "id") Long id) {
        return companyService.getEmp(id);
    }

    @PostMapping("/employee")
    ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
        return companyService.addEmp(employee);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmp(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        return companyService.updateEmp(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<Employee> deleteEmp(@PathVariable(name = "id") Long id) {
        return companyService.deleteEmp(id);
    }
}
