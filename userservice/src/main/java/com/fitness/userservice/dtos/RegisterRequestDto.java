package com.fitness.userservice.dtos;

import lombok.Data;

@Data
public class RegisterRequestDto {
  private String email;
  private String password;
  private String firstName;
  private String lastName;

}
