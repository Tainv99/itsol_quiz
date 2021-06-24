package com.example.demo.dto;

import java.util.List;

public class QuestionTestDTO {
    private Integer id;
    private Integer idTest;
    private Integer idQuestion;

    public QuestionTestDTO() {
    }

    public QuestionTestDTO(Integer id, Integer idTest, Integer idQuestion) {
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
