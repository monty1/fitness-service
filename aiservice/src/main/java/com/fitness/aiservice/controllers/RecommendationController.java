package com.fitness.aiservice.controllers;

import com.fitness.aiservice.dtos.RecommendationResponseDto;
import com.fitness.aiservice.services.RecommendationService;
import java.util.List;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/recommendations")
public class RecommendationController {

  @Autowired
  private RecommendationService recommendationService;

  @GetMapping("/user/{userId}")
  ResponseEntity<List<RecommendationResponseDto>> getUserRecommendations(
      @PathVariable String userId) {
    List<RecommendationResponseDto> recommendations =
        recommendationService.getUserRecommendations(userId);
    return ResponseEntity.ok(recommendations);
  }

  @GetMapping("/activity/{activityId}")
  ResponseEntity<RecommendationResponseDto> getActivityRecommendation(
      @PathVariable String activityId) {
    RecommendationResponseDto recommendationResponse =
        recommendationService.getActivityRecommendation(activityId);
    return ResponseEntity.ok(recommendationResponse);
  }
}
