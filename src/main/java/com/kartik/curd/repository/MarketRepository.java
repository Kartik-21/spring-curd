package com.kartik.curd.repository;

import com.kartik.curd.entity.compound_key.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
}
