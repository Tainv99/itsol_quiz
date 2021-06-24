package com.example.demo.service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuestionData;
import com.example.demo.dto.ResultDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.entity.QuestionBO;
import com.example.demo.mapper.AnwserMapper;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.repository.AnwserRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnwserMapper anwserMapper;
    @Autowired
    private AnwserRepository anwserRepository;

//    public List<QuestionDTO> getAll() {
//        List<QuestionDTO> listQuestion = new ArrayList<QuestionDTO>();
//        List<QuestionBO> bos = questionRepository.findAll();
//        for (int i = 0; i < bos.size(); i++) {
//            List<AnwserBO> ansbo = anwserRepository.getAnwserByQuesionId(bos.get(i).getId());
//            QuestionDTO questionDTO = questionMapper.toDto(bos.get(i));
//            List<AnwserDTO> anwserDTOListt = anwserMapper.toDto(ansbo);
//            questionDTO.setAnwserDTOList(anwserDTOListt);
//            listQuestion.add(questionDTO);
//        }
//        return listQuestion;
//    }

    public List<QuestionDTO> findAllQuestion() {
        List<QuestionDTO> questions = questionRepository.findAll().stream().map(questionMapper::toDto).collect(Collectors.toList());
        for (QuestionDTO question : questions) {
            List<ResultDTO> answers = anwserRepository.getAnwserByQuesionId(question.getId()).stream().map(ResultDTO::new).collect(Collectors.toList());
            question.setAnswerList(answers);
        }
        return questions;
    }

    public void addQuestionandAnwser(QuestionDTO questionDTO,Integer idQuiz) {
        QuestionBO bo = questionMapper.toEntity(questionDTO);
        bo.setIdUser(1);
        bo.setId_quiz(idQuiz);
        questionRepository.save(bo);
        List<ResultDTO> list = questionDTO.getAnswerList();
        for (int i = 0; i < list.size(); i++) {
            ResultDTO ans = list.get(i);
            AnwserBO bos = anwserMapper.toEntity(ans);
            bos.setIdQuestion(bo.getId());
            anwserRepository.save(bos);
            if (ans.isTrueOrFalse()==true){
                bo.setAnsCorrect(bos.getId()); questionRepository.save(bo);
            }
        }
    }

    public void updateQuestionAndAnwser(QuestionDTO questionDTO, Integer id) {
        Optional<QuestionBO> question = questionRepository.findById(id);
        if (question.isPresent()) {
            question.get().setText(questionDTO.getText());
//            question.get().setLevel(questionDTO.getLevel());
//            question.get().setAnsCorrect(questionDTO.getAnsCorrect());
//            question.get().setIdUser(questionDTO.getIdUser());
            questionRepository.save(question.get());
        }
        List<ResultDTO> listAns = questionDTO.getAnswerList();
        for (int i = 0; i < listAns.size(); i++) {
            ResultDTO ansdto = listAns.get(i);
            if (ansdto.getId() != null) {
                Optional<AnwserBO> ans = anwserRepository.findById(ansdto.getId());
                if (ans.isPresent()) {
                    ans.get().setTextanwser(ansdto.getTextanwser());
                    anwserRepository.save(ans.get());
                }
            }
            else {
                AnwserBO bo = anwserMapper.toEntity(ansdto);
                bo.setIdQuestion(id);
                anwserRepository.save(bo);
            }
        }
    }

    //update đáp án đúng
    public void updateQuestion(QuestionDTO questionDTO, Integer id) {
        Optional<QuestionBO> question = questionRepository.findById(id);
        if (question.isPresent()) {
            question.get().setAnsCorrect(questionDTO.getAnsCorrect());
            questionRepository.save(question.get());
        }
    }

    public void delete(Integer id) {
        questionRepository.deleteAllById(Collections.singleton(id));
    }

    public QuestionDTO getQuesInfoById(Integer id) {
        QuestionBO bos = questionRepository.getById(id);
        List<AnwserBO> ansbo = anwserRepository.getAnwserByQuesionId(bos.getId());
        QuestionDTO questionDTO = questionMapper.toDto(bos);
        List<ResultDTO> anwserDTOListt = anwserMapper.toDto(ansbo);
        questionDTO.setAnswerList(anwserDTOListt);
        return questionDTO;
    }

    public QuestionDTO findById(Integer id) {
        Optional<QuestionBO> boOpt = questionRepository.findById(id);
        boOpt.isPresent();
        return questionMapper.toDto(boOpt.get());
    }

    public List<QuestionDTO> getQuestion() {
        List<QuestionBO> bos = questionRepository.findAll();
        return questionMapper.toDto(bos);
    }

    public QuestionData saveQuiz(List<QuestionDTO> questions) {
        long total = 0;
        for (QuestionDTO question : questions) {
            Optional<QuestionBO> questionBO = questionRepository.findById(question.getId());
            if (questionBO.isPresent()) {
                for (ResultDTO answerDTO : question.getAnswerList()) {
                    if (answerDTO.getId() == questionBO.get().getAnsCorrect() && answerDTO.isChecked()) {
                        total++;
                    }
                    if (answerDTO.getId() == questionBO.get().getAnsCorrect()) {
                        answerDTO.setCorrect(true);
                    }
                }

            }
        }
        return new QuestionData(total, questions);
    }

}


