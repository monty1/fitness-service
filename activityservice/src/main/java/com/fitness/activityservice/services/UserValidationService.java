package com.fitness.activityservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class UserValidationService {

  @Autowired
  private  WebClient userServiceWebClient;

  public boolean validateUser(String userId) {
    return Boolean.TRUE.equals(
        userServiceWebClient.get().uri("/api/users/{userId}/validate", userId).retrieve()
            .bodyToMono(Boolean.class)
            .onErrorResume(WebClientResponseException.class, exception -> Mono.empty()).block());
  }
}
