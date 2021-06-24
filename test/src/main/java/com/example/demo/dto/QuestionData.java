package com.example.demo.dto;

import java.util.List;

public class QuestionData {
    private long total;

    private List<QuestionDTO> questions;

    public QuestionData(long total, List<QuestionDTO> questions) {
        this.total = total;
        this.questions = questions;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
