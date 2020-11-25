package com.vaudience.coding.exercise.vaudience.mapper;

import com.vaudience.coding.exercise.vaudience.domain.User;
import com.vaudience.coding.exercise.vaudience.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
