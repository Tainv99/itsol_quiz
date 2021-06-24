package com.example.demo.dto;

import com.example.demo.entity.QuestionTestBO;

import java.util.List;

public class TestDTO {
    private Integer id;
    private String name;

    private List<QuestionDTO> questionDTOList;

    public TestDTO() {
    }

    public TestDTO(Integer id, String name, List<QuestionDTO> questionDTOList) {
        this.id = id;
        this.name = name;
        this.questionDTOList = questionDTOList;
    }

    public List<QuestionDTO> getQuestionDTOList() {
        return questionDTOList;
    }

    public void setQuestionDTOList(List<QuestionDTO> questionDTOList) {
        this.questionDTOList = questionDTOList;
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
