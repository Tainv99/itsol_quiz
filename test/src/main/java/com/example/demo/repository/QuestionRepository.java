package com.example.demo.repository;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.entity.QuestionBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBO, Integer> {
    Optional<QuestionBO> findById(Integer id);
    @Query("select u from QuestionBO u where u.id = ?1")
    List<QuestionBO> getTestbyId(Integer idQuestion);
    @Query("select q from QuestionBO q where q.id_quiz = ?1")
    List<QuestionBO> getQuestionByIdQuiz(Integer idQuiz);
}
