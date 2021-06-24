package com.example.demo.controller;

import com.example.demo.dto.QuestionTestDTO;
import com.example.demo.service.QuestionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/qtest")
public class QuestionTestController {
    @Autowired
    private QuestionTestService questionTestService;

    @GetMapping()
    public ResponseEntity<List<QuestionTestDTO>> findAll() {
        List<QuestionTestDTO> dataRes = questionTestService.findAll();
        return ResponseEntity.ok(dataRes);
    }
    @PostMapping("/{idTest}")
    public String addQuestion(@RequestBody List<Integer> idListQuestion,@PathVariable Integer idTest) {
        questionTestService.addQuestiontoTest(idListQuestion,idTest);
        return "OK";
    }
}
