package com.example.demo.mapper;

import com.example.demo.dto.QuizDTO;
import com.example.demo.entity.QuizBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper extends EntityMapper<QuizDTO, QuizBO>{
}
