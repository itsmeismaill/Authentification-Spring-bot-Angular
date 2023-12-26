package com.example.backend.Mappers;


import com.example.backend.Dto.SignUpDto;
import com.example.backend.Dto.UserDto;
import com.example.backend.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface  UserMapper {
    UserDto toUserDto(User user);
    @Mapping(target="Password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
