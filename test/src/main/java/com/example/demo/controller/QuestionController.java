package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuestionData;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

//    @GetMapping("/ques")
//    public ResponseEntity<List<QuestionDTO>> getAll() {
//        List<QuestionDTO> dataResponse = questionService.getAll();
//        return ResponseEntity.ok(dataResponse);
//    }

    @GetMapping("info/{id}")
    public ResponseEntity<QuestionDTO> getQuesInfoById(@PathVariable Integer id) {
        QuestionDTO dataQues = questionService.getQuesInfoById(id);
        return ResponseEntity.ok(dataQues);
    }

    @PutMapping("/update/{id}")
    public String updateQuestionAndAnwser(@RequestBody QuestionDTO questionDTO, @PathVariable Integer id) {
        questionService.updateQuestionAndAnwser(questionDTO, id);
        return "OK";
    }

    @PostMapping("/{idQuiz}")
    public String addQuestion(@RequestBody QuestionDTO questionDTO,@PathVariable Integer idQuiz) {
        questionService.addQuestionandAnwser(questionDTO,idQuiz);
        return "OK";
    }
    @PostMapping("/test")
    public ResponseEntity<QuestionData> saveQuiz(@RequestBody List<QuestionDTO> questions) {
        QuestionData results = questionService.saveQuiz(questions);
        return ResponseEntity.ok(results);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> findById(@PathVariable Integer id) {
        QuestionDTO boOpt = questionService.findById(id);
        return ResponseEntity.ok(boOpt);
    }
    @PutMapping("/{id}")
    public String updateById(@RequestBody QuestionDTO questionDTO, @PathVariable Integer id) {
        questionService.updateQuestion(questionDTO, id);
        return "sua thanh cong";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        questionService.delete(id);
        return "xoa cau hoi thanh cong";
    }


    @GetMapping("/getQuestion")
    public ResponseEntity<List<QuestionDTO>> getQuestion(){
        List<QuestionDTO> respone = questionService.getQuestion();
        return ResponseEntity.ok(respone);
    }
    @GetMapping()
    public ResponseEntity<List<QuestionDTO>> getlistAll() {
        List<QuestionDTO> dataResponse = questionService.findAllQuestion();
        return ResponseEntity.ok(dataResponse);
    }

}
