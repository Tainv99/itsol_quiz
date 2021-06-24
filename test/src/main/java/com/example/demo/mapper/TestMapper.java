package com.example.demo.mapper;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.TestBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper extends EntityMapper<TestDTO, TestBO>{
}
