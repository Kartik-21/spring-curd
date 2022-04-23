package com.kartik.curd.controller;

import com.kartik.curd.entity.Address;
import com.kartik.curd.entity.Company;
import com.kartik.curd.entity.Employee;
import com.kartik.curd.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/common/")
public class CommonController {

    @Autowired
    CommonService service;

    @PostMapping("company/")
    ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return service.addCompany(company);
    }


    ///TODO: we can do with the map and get data in the method
    @PutMapping("{id}/")
    ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return service.updateCompany(id, company);
    }


    @DeleteMapping("address/{id}/")
    ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        return service.deleteAddress(id);
    }

    @PostMapping("address/")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
        System.out.println(address.toString());
        return service.addAddress(address);
    }

    @DeleteMapping("company/{id}/")
    ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
        return service.deleteCompany(id);
    }


    @PostMapping("employee/")
    ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
        return service.addEmp(employee);
    }


    @PutMapping("employee/{e_id}")
    ResponseEntity<Employee> updateEmp(@PathVariable(name = "e_id") Long id, @RequestBody Employee employee) {
        System.out.println(id);
        return service.updateEmp(id, employee);
    }


}
