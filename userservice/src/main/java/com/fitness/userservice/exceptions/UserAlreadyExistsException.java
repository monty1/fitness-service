package com.fitness.userservice.exceptions;

public class UserAlreadyExistsException extends UserServiceException {
  public UserAlreadyExistsException(String userEmail) {
    super("User already exists with email: " + userEmail);
  }
}
