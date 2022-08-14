package com.kartik.curd.controller;

import com.kartik.curd.entity.ResponseModel;
import com.kartik.curd.entity.compound_key.Market;
import com.kartik.curd.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */




@RestController
@RequestMapping("/market")
public class MarketController {


    @Autowired
    private MarketRepository marketRepository;

    @PostMapping
    public ResponseModel<Market> addMarket(@RequestBody Market market) {
        System.out.println(market.toString());
        return new ResponseModel<Market>(marketRepository.save(market), HttpStatus.CREATED);
    }

}
