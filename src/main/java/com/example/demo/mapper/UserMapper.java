package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface  UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    UserResponseDTO usertoUserResponseDTO(User user);

}
