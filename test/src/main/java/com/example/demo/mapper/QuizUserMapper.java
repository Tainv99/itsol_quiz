package com.example.demo.mapper;

import com.example.demo.dto.QuizUserDTO;
import com.example.demo.entity.QuizUserBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizUserMapper extends EntityMapper<QuizUserDTO, QuizUserBO>{
}
