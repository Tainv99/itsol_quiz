package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuizDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.entity.QuestionBO;
import com.example.demo.entity.QuizBO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.QuizMapper;
import com.example.demo.repository.AnwserRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizMapper quizMapper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnwserRepository anwserRepository;

    public List<QuizDTO> findAll(){
        List<QuizBO> bo = quizRepository.findAll();
        return quizMapper.toDto(bo);
    }
    public List<QuizDTO> findById(Integer id){
        List<QuizDTO> quizDTOS = new ArrayList<QuizDTO>();
        QuizBO bo = quizRepository.getById(id);
        List<QuestionBO> quesbo = questionRepository.getQuestionByIdQuiz(bo.getId());
        QuizDTO dto = quizMapper.toDto(bo);
        List<QuestionDTO> quesDTOListt = questionMapper.toDto(quesbo);
        dto.setQuestionDTO(quesDTOListt);
        for (QuestionDTO question : quesDTOListt) {
            List<ResultDTO> answers = anwserRepository.getAnwserByQuesionId(question.getId()).stream().map(ResultDTO::new).collect(Collectors.toList());
            question.setAnswerList(answers);
        }
        quizDTOS.add(dto);
        return quizDTOS;
    }

    public void updateQuiz(QuizDTO quizDTO,Integer id){
        Optional<QuizBO> bo = quizRepository.findById(id);
        if(bo.isPresent()){
            bo.get().setName(quizDTO.getName());
            quizRepository.save(bo.get());
        }
    }
    public void addQuiz(QuizDTO quizDTO){
        QuizBO bo = quizMapper.toEntity(quizDTO);
        quizRepository.save(bo);
    }

    public void deleteQuiz(Integer id){
        quizRepository.deleteById(id);
    }

    //
    public List<QuestionDTO> findQuestionByQuizId(Integer id) {
        Optional<QuizBO> quizBO = quizRepository.findById(id);
        if (!quizBO.isPresent()) {
            throw new RuntimeException();
        }
        List<QuestionBO> questionBOS = questionRepository.getQuestionByIdQuiz(id);
        List<QuestionDTO> questions = questionMapper.toDto(questionBOS);
        for (QuestionDTO question : questions) {
            List<ResultDTO> answers = anwserRepository.getAnwserByQuesionId(question.getId()).stream().map(ResultDTO::new).collect(Collectors.toList());
            question.setAnswerList(answers);
        }
        return questions;
    }
}
