package com.example.demo.dto;

import java.util.List;

public class QuizDTO {
    private Integer id;
    private String name;

    private List<QuestionDTO> questionDTO;

    public QuizDTO() {
    }

    public QuizDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionDTO> getQuestionDTO() {
        return questionDTO;
    }

    public void setQuestionDTO(List<QuestionDTO> questionDTO) {
        this.questionDTO = questionDTO;
    }
}
