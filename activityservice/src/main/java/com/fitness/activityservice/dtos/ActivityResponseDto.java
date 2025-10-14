package com.fitness.activityservice.dtos;

import com.fitness.activityservice.models.ActivityType;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;

@Data
public class ActivityResponseDto {
  private String id;
  private String userId;
  private Integer duration;
  private Integer caloriesBurned;
  private ActivityType type;
  private Map<String, Object> attributes;
  private LocalDateTime startTime;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
