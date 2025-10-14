package com.fitness.aiservice.repositories;

import com.fitness.aiservice.models.Recommendation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
  List<Recommendation> findByUserId(String userId);

  Optional<Recommendation> findByActivityId(String activityId);
}
