package com.example.demo.service;

import com.example.demo.dto.QuizUserDTO;
import com.example.demo.entity.QuizUserBO;
import com.example.demo.mapper.QuizUserMapper;
import com.example.demo.repository.QuizUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizUserService {
    @Autowired
    QuizUserRepository quizUserRepository;
    @Autowired
    QuizUserMapper quizUserMapper;

    public List<QuizUserDTO> findAll(){
        List<QuizUserBO> bo = quizUserRepository.findAll();
        return quizUserMapper.toDto(bo);
    }

    public void addDTO(int idquiz,int mark){
        QuizUserDTO quizUserDTO =new QuizUserDTO();
        QuizUserBO bo = quizUserMapper.toEntity(quizUserDTO);
        bo.setIdUser(1);
        bo.setMark(mark);
        bo.setIdQuiz(idquiz);
        quizUserRepository.save(bo);
    }

    public QuizUserDTO findById(Integer id) {
        Optional<QuizUserBO> boOpt = quizUserRepository.findById(id);
        boOpt.isPresent();
        return quizUserMapper.toDto(boOpt.get());
    }

    public String check(int idQuiz,double mark){
        if (!quizUserRepository.existsByIdQuiz(idQuiz)){
            QuizUserDTO quizUserDTO =new QuizUserDTO();
            QuizUserBO bo = quizUserMapper.toEntity(quizUserDTO);
            bo.setIdUser(1);
            bo.setIdQuiz(idQuiz);
            bo.setMark(mark);
            quizUserRepository.save(bo);
            return "thêm thành công";
        }
        return "đã làm bài rồi!!";
    }
}
