package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping()
    public ResponseEntity<List<TestDTO>> findAll() {
        List<TestDTO> dataReponse = testService.findAll();
        return ResponseEntity.ok(dataReponse);
    }
    @GetMapping("info/{id}")
    public ResponseEntity<List<TestDTO>> getQuesInfoById(@PathVariable Integer id) {
        List<TestDTO> dataQues = testService.getTestById(id);
        return ResponseEntity.ok(dataQues);
    }
}
