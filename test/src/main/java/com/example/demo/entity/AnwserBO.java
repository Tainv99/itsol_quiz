package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_anwser")
public class AnwserBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anwser")
    private Integer id;

    @Column(name = "textanwser")
    private String textanwser;

    @Column(name = "id_question")
    private Integer idQuestion;

    public AnwserBO() {
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
