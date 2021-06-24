package com.example.demo.dto;


public class AnwserDTO {
    private Integer id;
    private String textanwser;
    private Integer idQuestion;

    public AnwserDTO() {
    }

    public AnwserDTO(Integer id, String textanwser, Integer idQuestion) {
        this.id = id;
        this.textanwser = textanwser;
        this.idQuestion = idQuestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextanwser() {
        return textanwser;
    }

    public void setTextanwser(String textanwser) {
        this.textanwser = textanwser;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }
}
