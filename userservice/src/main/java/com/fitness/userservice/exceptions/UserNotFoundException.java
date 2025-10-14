package com.fitness.userservice.exceptions;

public class UserNotFoundException extends UserServiceException {
  public UserNotFoundException(String userId) {
    super("User not found with id: " + userId);
  }
}
