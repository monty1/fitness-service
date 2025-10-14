package com.fitness.userservice.services;

import com.fitness.userservice.dtos.RegisterRequestDto;
import com.fitness.userservice.dtos.UserResponseDto;

public interface UserService {
  UserResponseDto registerUser(RegisterRequestDto registerRequestDto);

  UserResponseDto getUserProfileById(String userId);

  void deleteUserById(String userId);

  Boolean existsByUserId(String userId);
}
