package com.example.demo.repository;

import com.example.demo.entity.QuestionBO;
import com.example.demo.entity.QuestionTestBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTestRepository extends JpaRepository<QuestionTestBO,Integer> {
    @Query("select u from QuestionTestBO u where u.idTest = ?1")
    List<QuestionTestBO> getTestbyId(Integer id);

}
