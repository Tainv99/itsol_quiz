package com.example.demo.dto;


import com.example.demo.entity.QuestionBO;

import java.util.List;

public class QuestionDTO {
    private Integer id;
    private String text;
    private char level;
    private int ansCorrect;
    private int idUser;
    private int id_quiz;
//    private List<AnwserDTO> anwserDTOList;

    private List<ResultDTO> answerList;

    public QuestionDTO() {
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public QuestionDTO(int ansCorrect) {
        this.ansCorrect = ansCorrect;
    }

    public QuestionDTO(Integer id, String text, char level, int ansCorrect, int idUser, int id_quiz) {
        this.id = id;
        this.text = text;
        this.level = level;
        this.ansCorrect = ansCorrect;
        this.idUser = idUser;
        this.id_quiz = id_quiz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public int getAnsCorrect() {
        return ansCorrect;
    }

    public void setAnsCorrect(int ansCorrect) {
        this.ansCorrect = ansCorrect;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

//    public List<AnwserDTO> getAnwserDTOList() {
//        return anwserDTOList;
//    }
//
//    public void setAnwserDTOList(List<AnwserDTO> anwserDTOList) {
//        this.anwserDTOList = anwserDTOList;
//    }

    public List<ResultDTO> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<ResultDTO> answerList) {
        this.answerList = answerList;
    }
}
