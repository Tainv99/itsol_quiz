package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> dataResponse = userService.findAll();
        return ResponseEntity.ok(dataResponse);
    }

    @PostMapping("register")
    public String register(@RequestBody UserDTO dto){
        userService.save(dto);
        return "Đăng ký thành công";
    }
}
