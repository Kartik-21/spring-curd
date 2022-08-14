package com.kartik.curd.repository;

import com.kartik.curd.entity.bank.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kartik Jain
 * version: 1.0
 * since: 13 Jun 2022
 */
@Repository
public interface BankRepository extends JpaRepository<Account, Long> {
}
