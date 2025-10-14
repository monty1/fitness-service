package com.fitness.userservice.controllers;

import com.fitness.userservice.dtos.RegisterRequestDto;
import com.fitness.userservice.dtos.UserResponseDto;
import com.fitness.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponseDto> registerUser(@RequestBody
                                                      RegisterRequestDto registerRequestDto) {
    UserResponseDto userResponseDto = userService.registerUser(registerRequestDto);
    return ResponseEntity.ok(userResponseDto);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponseDto> getUserProfileById(@PathVariable String userId) {
    UserResponseDto userResponseDto = userService.getUserProfileById(userId);
    return ResponseEntity.ok(userResponseDto);
  }

  @GetMapping("/{userId}/validate")
  public ResponseEntity<Boolean> validateUserByUserId(@PathVariable String userId) {
    boolean userExists = userService.existsByUserId(userId);
    return ResponseEntity.ok(userExists);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUserById(@PathVariable String userId) {
    userService.deleteUserById(userId);
    return ResponseEntity.ok().build();
  }
}
