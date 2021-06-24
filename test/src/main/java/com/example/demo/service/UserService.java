package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserBO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void save(UserDTO userDTO){
        UserBO bo = userMapper.toEntity(userDTO);
        bo.setRole("USER");
        bo.setPasswordHash(passwordEncoder.encode(bo.getPasswordHash()));
        userRepository.save(bo);
    }
    public List<UserDTO> findAll(){
        List<UserBO> bo= userRepository.findAll();
        return userMapper.toDto(bo);
    }
}
