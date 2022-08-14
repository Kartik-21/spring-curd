package com.kartik.curd.controller;

import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.entity.bank.Account;
import com.kartik.curd.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */

@RestController
@RequestMapping("/bank")
public class BankController {


    @Autowired
    private BankRepository bankRepository;

    @PostMapping
    public ResponseModel<Account> saveAccount(@RequestBody Account account) {
        return new ResponseModel<>(bankRepository.save(account), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseModel<Account> getAccount(@PathVariable Long id) {
        return new ResponseModel<>(bankRepository.findById(id).get(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseModel<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return new ResponseModel<>(bankRepository.save(account), HttpStatus.OK);
    }

}
