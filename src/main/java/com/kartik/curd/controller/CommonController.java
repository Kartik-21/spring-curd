package com.kartik.curd.controller;

import com.kartik.curd.entity.Address;
import com.kartik.curd.entity.Company;
import com.kartik.curd.entity.Employee;
import com.kartik.curd.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

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
    @PutMapping("company/{id}/")
    ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {

//        LocalDate localDateTime = LocalDate.of(2520, Month.APRIL, 51);
//
//        LocalTime localTime = LocalTime.of(12, 52);
//        LocalDateTime localDateTime1 = LocalDateTime.of(localDateTime, localTime);
//        LocalDate localDate = LocalDateTime.now().toLocalDate();
//        LocalDate localDate1 = localDate.plusDays(1);
//        localDate1.isAfter(localDate);
//
//        LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
//        LocalDate.parse("DD/MM/yyyy");
//
//
//        DayOfWeek dayOfWeek = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
//
//
//        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("nm,"));
//        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("nm,"));
//
//        int i = zonedDateTime.getHour() - zonedDateTime1.getHour();

        return service.updateCompany(id, company);
    }

    @GetMapping("company/{id}/")
    ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {
        return service.getCompany(id);
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
        return service.updateEmp(id, employee);
    }

    @GetMapping("employee/{e_id}")
    ResponseEntity<Employee> getEmp(@PathVariable(name = "e_id") Long id) {
        return service.getEmp(id);
    }

    @DeleteMapping("employee/{e_id}")
    ResponseEntity<Employee> deleteEmp(@PathVariable(name = "e_id") Long id) {
        return service.deleteEmp(id);
    }


}
