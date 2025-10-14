package com.fitness.activityservice.exceptions;

public class InvalidUserException extends RuntimeException{

  public InvalidUserException(String userId){
    super("invalid user found for userId: " +userId);
  }
}
