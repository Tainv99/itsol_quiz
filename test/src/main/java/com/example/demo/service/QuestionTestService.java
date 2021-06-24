package com.example.demo.service;

import com.example.demo.dto.AnwserDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuestionTestDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.entity.QuestionBO;
import com.example.demo.entity.QuestionTestBO;
import com.example.demo.entity.TestBO;
import com.example.demo.mapper.QuestionTestMapper;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuestionTestRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionTestService {
    @Autowired
    private QuestionTestRepository questionTestRepository;
    @Autowired
    private QuestionTestMapper questionTestMapper;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;
    public List<QuestionTestDTO> findAll(){
        List<QuestionTestBO> bos = questionTestRepository.findAll();
        return questionTestMapper.toDto(bos);
    }
    //add question to test
    //xây dựng hàm lấy id
    //click--> detail--log id
    public void addQuestiontoTest(List<Integer> idQuestion, Integer idTest){
        Optional<TestBO> testBO = testRepository.findById(idTest);
        for (int i=0; i<idQuestion.size();i++){
            QuestionTestDTO dto = new QuestionTestDTO();
            dto.setIdTest(idTest);
            dto.setIdQuestion(idQuestion.get(i));
            QuestionTestBO bo = questionTestMapper.toEntity(dto);
            questionTestRepository.save(bo);
        }
    }
//    public List<QuestionTestDTO> getAll() {
//        List<QuestionTestDTO> listQuestion = new ArrayList<QuestionTestDTO>();
//        List<QuestionTestBO> bos = questionTestRepository.findAll();
//        for (int i = 0; i < bos.size(); i++) {
//            List<QuestionBO> ansbo = questionRepository.getTestbyId(bos.get(i).getId());
//            QuestionDTO questionDTO = questionMapper.toDto(bos.get(i));
//            List<AnwserDTO> anwserDTOListt = anwserMapper.toDto(ansbo);
//            questionDTO.setAnwserDTOList(anwserDTOListt);
//            listQuestion.add(questionDTO);
//        }
//        return listQuestion;
//    }
}
