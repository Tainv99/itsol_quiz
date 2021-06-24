package com.example.demo.dao;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuizUserDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QuizUserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<QuizUserDTO> getMark(int idQuiz) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(" u.username, ");
        sql.append(" q.name, ");
        sql.append(" qu.mark ");
        sql.append(" from tbl_quiz q ");
        sql.append(" inner join tbl_quiz_user qu on q.id_quiz=qu.id_quiz ");
        sql.append("  inner join tbl_user U on qu.id_user=u.id_user ");
        sql.append(" where q.id_quiz ="+ idQuiz);
        Query query = entityManager.createNativeQuery(sql.toString(), "mapping");
        return query.getResultList();
    }
}
