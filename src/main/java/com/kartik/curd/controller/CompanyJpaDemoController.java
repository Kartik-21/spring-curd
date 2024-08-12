package com.kartik.curd.controller;


import com.kartik.curd.entity.Company;
import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/company")
@RestController
public class CompanyJpaDemoController {


    @Autowired
    private CompanyRepository companyRepository;

//    @GetMapping
//    ResponseEntity<List<Company>> getDistinctCompany(){
//      return  ResponseEntity.ok(companyRepository.findAllByDistinct());
//    }

    @GetMapping("/all")
    ResponseModel<List<Company>> getAll() {
        return new ResponseModel<List<Company>>(companyRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<Company>(companyRepository.save(company), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    ResponseModel<Company> updateCompany(@PathVariable long id, @RequestBody Company company) {

        Optional<Company> updatedCompany = companyRepository.findById(id);

        if (updatedCompany.isPresent()) {
            updatedCompany.get().setCompanyName("Company name updated");
            return new ResponseModel<Company>(companyRepository.save(updatedCompany.get()), HttpStatus.OK);
        }
        return new ResponseModel<Company>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/demo")
    ResponseModel<List<Company>> getDemo() {
        return new ResponseModel<List<Company>>(companyRepository.findByCompanyNameIn(List.of("Mab","Axz")), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyRepository.findById(id).get(), HttpStatus.OK);
    }

}
