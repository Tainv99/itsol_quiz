package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuizDTO;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<List<QuizDTO>> findAll(){
        List<QuizDTO> data = quizService.findAll();
        return ResponseEntity.ok(data);
    }
    @GetMapping("/{id}")
    public List<QuizDTO> findById(@PathVariable Integer id){
        List<QuizDTO> dto = quizService.findById(id);
        return dto;
    }

    @PostMapping
    public String addQuiz(@RequestBody QuizDTO quizDTO){
        quizService.addQuiz(quizDTO);
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Integer id){
        quizService.deleteQuiz(id);
        return "xóa thành công";
    }
    @GetMapping("/list/{id}")
    public List<QuestionDTO> findQuestionByIdQuiz(@PathVariable Integer id){
        List<QuestionDTO> data =quizService.findQuestionByQuizId(id);
        return data;
    }
}
