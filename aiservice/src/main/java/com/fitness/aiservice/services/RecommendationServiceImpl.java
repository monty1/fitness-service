package com.fitness.aiservice.services;

import com.fitness.aiservice.dtos.RecommendationResponseDto;
import com.fitness.aiservice.exceptions.RecommendationNotFoundException;
import com.fitness.aiservice.mappers.RecommendationDataMapper;
import com.fitness.aiservice.models.Recommendation;
import com.fitness.aiservice.repositories.RecommendationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

  @Autowired
  private RecommendationRepository recommendationRepository;

  @Autowired
  private RecommendationDataMapper recommendationDataMapper;

  @Override
  public List<RecommendationResponseDto> getUserRecommendations(String userId) {
    List<Recommendation> recommendationsForUser =
        recommendationRepository.findByUserId(userId);
    return recommendationDataMapper.mapRecommendationEntitiesToResponses(recommendationsForUser);
  }

  @Override
  public RecommendationResponseDto getActivityRecommendation(String activityId) {
    Recommendation recommendationsForActivity =
        recommendationRepository.findByActivityId(activityId)
            .orElseThrow(() -> new RecommendationNotFoundException(activityId));
    return recommendationDataMapper.mapRecommendationEntityToResponse(recommendationsForActivity);
  }
}
