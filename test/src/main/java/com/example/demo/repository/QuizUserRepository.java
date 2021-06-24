package com.example.demo.repository;

import com.example.demo.entity.QuestionBO;
import com.example.demo.entity.QuizUserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizUserRepository extends JpaRepository<QuizUserBO,Integer> {
    @Query("select u.idQuiz from QuizUserBO u where u.idQuiz = ?1")
    Optional<QuizUserBO> findByidQuiz(int idquiz);

    boolean existsByIdQuiz(int idQuiz);
}
