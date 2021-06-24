package com.example.demo.service;

import com.example.demo.dto.AnwserDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.entity.AnwserBO;
import com.example.demo.mapper.AnwserMapper;
import com.example.demo.repository.AnwserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnwserService {
    @Autowired
    private AnwserRepository anwserRepository;
    @Autowired
    private AnwserMapper anwserMapper;

    public List<ResultDTO> getAnwser() {
        List<AnwserBO> bos = anwserRepository.findAll();
        return anwserMapper.toDto(bos);
    }
//add list anwser
//    public void addAnwser(List<AnwserDTO> anwserDTO) {
//        for (int i=0;i<anwserDTO.size();i++){
//            AnwserBO bo = anwserMapper.toEntity(anwserDTO.get(i));
//            anwserRepository.save(bo);
//        }
//        AnwserBO bo = anwserMapper.toEntity(anwserDTO);
//        anwserRepository.save(bo);
//    }

//    public void addAnwser(AnwserDTO anwserDTO) {
//        AnwserBO bo = anwserMapper.toEntity(anwserDTO);
//        anwserRepository.save(bo);
//    }
//    public void updateAnwser(AnwserDTO anwserDTO, Integer id) {
//        Optional<AnwserBO> ans = anwserRepository.findById(id);
//        if (ans.isPresent()) {
//            ans.get().setTextanwser(anwserDTO.getTextanwser());
//            anwserRepository.save(ans.get());
//        }
//    }
//
//    public void delete(Integer id) {
//        anwserRepository.deleteById(id);
//    }
//
//    public void addQuestionToTest(List<Integer> idQuestion, Integer idTest){
//
//    }
}
