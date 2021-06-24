package com.example.demo.service;

import com.example.demo.dto.AnwserDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.dto.QuestionTestDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.entity.QuestionBO;
import com.example.demo.entity.QuestionTestBO;
import com.example.demo.entity.TestBO;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.QuestionTestMapper;
import com.example.demo.mapper.TestMapper;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuestionTestRepository;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private QuestionTestMapper questionTestMapper;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionTestRepository questionTestRepository;

    public List<TestDTO> findAll(){
        List<TestBO> bos = testRepository.findAll();
        return testMapper.toDto(bos);
    }
    public void addTest(TestDTO testDTO){
        TestBO bo = testMapper.toEntity(testDTO);
        testRepository.save(bo);
    }
    public void updateTest(TestDTO testDTO,Integer id){
        Optional<TestBO> testBO = testRepository.findById(id);
        if (testBO.isPresent()){
            testBO.get().setName(testDTO.getName());
            testRepository.save(testBO.get());
        }
    }
    public void deleteTest(Integer id){
        testRepository.deleteById(id);
    }

    public List<TestDTO> getTestById(Integer id) {
        List<TestDTO> dto =new ArrayList<TestDTO>();
        TestBO bo = testRepository.getById(id);
//        List<QuestionTestBO> quesbo = questionTestRepository.getTestbyId(bo.getId());//lấy questiontest có id =id bài test
        TestDTO testDTO = testMapper.toDto(bo);
//        List<QuestionTestDTO> DTOListt = questionTestMapper.toDto(quesbo);
//        testDTO.setQuestionDTOList(DTOListt);
        dto.add(testDTO);
        return dto;
    }
}
