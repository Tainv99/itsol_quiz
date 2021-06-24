package com.example.demo.dao;

import com.example.demo.dto.QuestionDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QuestionDao {
    @PersistenceContext
    private EntityManager entityManager;

//    public List<QuestionDTO> getAllDto() {
//        StringBuilder sql = new StringBuilder();
//        sql.append(" SELECT ");
//        sql.append(" Q.ans_correct ");
//        sql.append(" FROM tbl_question Q ");
//        sql.append("  INNER JOIN tbl_anwser A on Q.id_question=A.id_question ");
//        sql.append("  WHERE Q.ans_correct=A.id_anwser ");
//        Query query = entityManager.createNativeQuery(sql.toString(), "mappingssss");
//        return query.getResultList();
//    }
}
