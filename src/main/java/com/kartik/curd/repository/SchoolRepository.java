package com.kartik.curd.repository;

import com.kartik.curd.entity.school.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<Teacher, Long> {
}
