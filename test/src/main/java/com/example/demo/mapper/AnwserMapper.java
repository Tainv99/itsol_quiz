package com.example.demo.mapper;


import com.example.demo.dto.AnwserDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.entity.AnwserBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnwserMapper extends EntityMapper<ResultDTO, AnwserBO> {
}
