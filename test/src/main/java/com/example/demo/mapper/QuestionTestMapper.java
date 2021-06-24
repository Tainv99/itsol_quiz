package com.example.demo.mapper;

import com.example.demo.dto.QuestionTestDTO;
import com.example.demo.entity.QuestionTestBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionTestMapper extends EntityMapper<QuestionTestDTO, QuestionTestBO>{
}
