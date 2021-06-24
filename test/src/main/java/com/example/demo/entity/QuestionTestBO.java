package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_test_question")
public class QuestionTestBO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_test")
    private Integer idTest;

    @Column(name = "id_question")
    private Integer idQuestion;

    public QuestionTestBO() {
    }

    public QuestionTestBO(Integer id, Integer idTest, Integer idQuestion) {
        this.id = id;
        this.idTest = idTest;
        this.idQuestion = idQuestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }
}
