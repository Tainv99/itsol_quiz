package com.example.demo.repository;

import com.example.demo.entity.TestBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestBO, Integer> {

}
