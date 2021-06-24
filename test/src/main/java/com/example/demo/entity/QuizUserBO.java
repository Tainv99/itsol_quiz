package com.example.demo.entity;


import com.example.demo.dto.QuizUserDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_quiz_user")
@SqlResultSetMapping(
        name = "mapping",
        classes = {
                @ConstructorResult(
                        targetClass = QuizUserDTO.class,
                        columns = {
                                @ColumnResult(name = "username", type = String.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "mark", type = double.class),
                        }
                )
        }
)
public class QuizUserBO {
    @Id
    @Column(name = "id_qt")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_quiz")
    private int idQuiz;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "mark")
    private double mark;

    public QuizUserBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
