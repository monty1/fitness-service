package com.fitness.aiservice.mappers;

import com.fitness.aiservice.dtos.RecommendationResponseDto;
import com.fitness.aiservice.models.Recommendation;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationDataMapper {

  RecommendationResponseDto mapRecommendationEntityToResponse(Recommendation recommendation);

  List<RecommendationResponseDto> mapRecommendationEntitiesToResponses(List<Recommendation> recommendations);
}
