package com.kartik.controller;

import com.kartik.dto.ResponseModel;
import com.kartik.entity.Address;
import com.kartik.entity.Company;
import com.kartik.entity.Employee;
import com.kartik.repository.CompanyRepository;
import com.kartik.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CompanyController {

    private final CompanyService service;

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyService service, CompanyRepository companyRepository) {
        this.service = service;
        this.companyRepository = companyRepository;
    }

    @PostMapping("/company")
    ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return service.createCompany(company);
    }

    @PutMapping("/company/{id}/")
    ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return service.updateCompany(id, company);
    }

    @GetMapping("/company/{id}/")
    ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.companyDetails(id));
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

    //    @GetMapping
//    ResponseEntity<List<Company>> getDistinctCompany(){
//      return  ResponseEntity.ok(companyRepository.findAllByDistinct());
//    }

    @GetMapping("/all")
    ResponseModel<List<Company>> getAll() {
        return new ResponseModel<List<Company>>(companyRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseModel<Company> updateCompany(@PathVariable long id, @RequestBody Company company) {

        Optional<Company> updatedCompany = companyRepository.findById(id);

        if (updatedCompany.isPresent()) {
//            updatedCompany.get().setCompanyName("Company name updated");
            return new ResponseModel<Company>(companyRepository.save(updatedCompany.get()), HttpStatus.OK);
        }
        return new ResponseModel<Company>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/demo")
    ResponseModel<List<Company>> getDemo() {
//        return new ResponseModel<List<Company>>(companyRepository.findByCompanyNameIn(List.of("Mab", "Axz")), HttpStatus.OK);
        return null;
    }

}
