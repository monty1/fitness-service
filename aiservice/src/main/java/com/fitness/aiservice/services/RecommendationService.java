package com.fitness.aiservice.services;

import com.fitness.aiservice.dtos.RecommendationResponseDto;
import java.util.List;

public interface RecommendationService {

  List<RecommendationResponseDto> getUserRecommendations(String userId);

  RecommendationResponseDto getActivityRecommendation(String activityId);
}
