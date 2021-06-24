package com.example.demo.mapper;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.QuestionBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends EntityMapper<QuestionDTO, QuestionBO> {
}
