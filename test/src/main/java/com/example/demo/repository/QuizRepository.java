package com.example.demo.repository;

import com.example.demo.entity.QuizBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizBO, Integer> {
}
