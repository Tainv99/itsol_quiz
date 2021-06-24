package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_quiz")
public class QuizBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quiz")
    private Integer id;

    @Column(name = "name")
    private String name;

    public QuizBO() {
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
}
