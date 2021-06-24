package com.example.demo.dto;

import com.example.demo.entity.AnwserBO;

public class ResultDTO {
    private Integer id;

    private String textanwser;

    private boolean checked;

    private boolean correct;

    private Integer idQuestion;

    private boolean trueOrFalse;

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }
    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public ResultDTO() {
    }

    public ResultDTO(AnwserBO anwserBO) {
        this.id = anwserBO.getId();
        this.textanwser = anwserBO.getTextanwser();
        this.checked = false;
        this.correct = false;
    }

    public ResultDTO(Integer id, String textanwser, Integer idQuestion) {
        this.id = id;
        this.textanwser = textanwser;
        this.idQuestion = idQuestion;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
