package com.fitness.aiservice.exceptions;

public class RecommendationNotFoundException extends RuntimeException{

  public RecommendationNotFoundException(String argument){
    super("Recommendations not found for id: " + argument);
  }
}
