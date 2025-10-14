package com.fitness.userservice.services;

import com.fitness.userservice.dtos.RegisterRequestDto;
import com.fitness.userservice.dtos.UserResponseDto;
import com.fitness.userservice.exceptions.UserAlreadyExistsException;
import com.fitness.userservice.exceptions.UserNotFoundException;
import com.fitness.userservice.mappers.UserDataMapper;
import com.fitness.userservice.models.User;
import com.fitness.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDataMapper userDataMapper;

  @Override
  @Transactional
  public UserResponseDto registerUser(RegisterRequestDto registerRequestDto) {
    if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
      throw new UserAlreadyExistsException(registerRequestDto.getEmail());
    }
    User user = userDataMapper.userRequestDtoToUserEntity(registerRequestDto);
    User savedUser = userRepository.save(user);
    return userDataMapper.userEntityToUserResponse(savedUser);
  }

  @Override
  public UserResponseDto getUserProfileById(String userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException(userId));
    return userDataMapper.userEntityToUserResponse(user);
  }

  @Override
  public void deleteUserById(String userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public Boolean existsByUserId(String userId) {
    return userRepository.existsById(userId);
  }
}
