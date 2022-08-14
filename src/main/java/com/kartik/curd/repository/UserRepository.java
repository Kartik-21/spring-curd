package com.kartik.curd.repository;

import com.kartik.curd.entity.bank.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
