package com.kartik.curd.repository;

import com.kartik.curd.entity.school.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
