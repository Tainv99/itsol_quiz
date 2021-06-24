package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserMapper extends EntityMapper<UserDTO, UserBO>{
}
