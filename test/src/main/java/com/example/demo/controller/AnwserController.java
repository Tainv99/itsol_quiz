package com.example.demo.controller;

import com.example.demo.dto.AnwserDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.service.AnwserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/ans")
public class AnwserController {
    @Autowired
    private AnwserService anwserService;

    @GetMapping()
    public ResponseEntity<List<ResultDTO>> getAnwser() {
        List<ResultDTO> dataRes = anwserService.getAnwser();
        return ResponseEntity.ok(dataRes);
    }
//add list anwser
//    @PostMapping
//    public String addAnwser(@RequestBody List<AnwserDTO> anwserDTO) {
//        anwserService.addAnwser(anwserDTO);
//        return "OK";
//    }

//    @PostMapping
//    public String addAnwser(@RequestBody AnwserDTO anwserDTO) {
//        anwserService.addAnwser(anwserDTO);
//        return "OK";
//    }
//
//    @PutMapping("/{id}")
//    public String updateAnwser(@RequestBody AnwserDTO anwserDTO, @PathVariable Integer id) {
//        anwserService.updateAnwser(anwserDTO, id);
//        return "sua thanh cong";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteAnws(@PathVariable Integer id) {
//        anwserService.delete(id);
//        return "xoa thanh cong";
//    }
}
