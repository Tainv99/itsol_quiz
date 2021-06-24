package com.example.demo.controller;

import com.example.demo.dao.QuizUserDao;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuizUserDTO;
import com.example.demo.service.QuizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/qt")
public class QuizUserController {
    @Autowired
    private QuizUserService quizUserService;
    @Autowired
    private QuizUserDao quizUserDao;
    @GetMapping()
    public ResponseEntity<List<QuizUserDTO>> findAll(){
        List<QuizUserDTO> data = quizUserService.findAll();
        return ResponseEntity.ok(data);
    }
    @GetMapping("/getmark/{idQuiz}")
    public ResponseEntity<List<QuizUserDTO>> getAllDTO(@PathVariable int idQuiz) {
        List<QuizUserDTO> dataResponse = quizUserDao.getMark(idQuiz);
        return ResponseEntity.ok(dataResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuizUserDTO> findById(@PathVariable Integer id) {
        QuizUserDTO boOpt = quizUserService.findById(id);
        return ResponseEntity.ok(boOpt);
    }
    @PostMapping("/{idQuiz}/{mark}")
    public String addDTO(@PathVariable int idQuiz,@PathVariable int mark){
        quizUserService.addDTO(idQuiz,mark);
        return "ok";
    }
    @PostMapping("test/{idQuiz}/{mark}")
    public String check(@PathVariable int idQuiz,@PathVariable double mark){
        return quizUserService.check(idQuiz,mark);
    }
}
