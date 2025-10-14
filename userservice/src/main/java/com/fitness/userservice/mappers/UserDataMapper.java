package com.fitness.userservice.mappers;

import com.fitness.userservice.dtos.RegisterRequestDto;
import com.fitness.userservice.dtos.UserResponseDto;
import com.fitness.userservice.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDataMapper {

  User userRequestDtoToUserEntity(RegisterRequestDto registerRequestDto);
  UserResponseDto userEntityToUserResponse(User user);
}
