package com.fitness.activityservice.services;

import com.fitness.activityservice.dtos.ActivityRequestDto;
import com.fitness.activityservice.dtos.ActivityResponseDto;

public interface ActivityService {
  ActivityResponseDto trackActivity(ActivityRequestDto activityRequest);
}
