package com.example.demo.repository;

import com.example.demo.entity.AnwserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnwserRepository extends JpaRepository<AnwserBO, Integer> {
    @Query("select u from AnwserBO u where u.idQuestion = ?1")
    List<AnwserBO> getAnwserByQuesionId(Integer idQuestion);

}
