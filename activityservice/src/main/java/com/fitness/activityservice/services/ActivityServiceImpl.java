package com.fitness.activityservice.services;

import com.fitness.activityservice.dtos.ActivityRequestDto;
import com.fitness.activityservice.dtos.ActivityResponseDto;
import com.fitness.activityservice.exceptions.InvalidUserException;
import com.fitness.activityservice.mappers.ActivityDataMapper;
import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityServiceImpl implements ActivityService{

  @Autowired
  private ActivityRepository activityRepository;

  @Autowired
  private UserValidationService userValidationService;

  @Autowired
  private ActivityDataMapper activityDataMapper;

  @Override
  @Transactional
  public ActivityResponseDto trackActivity(ActivityRequestDto activityRequest) {
    boolean isValidUser  = userValidationService.validateUser(activityRequest.getUserId());
    if(!isValidUser)
    {
      throw new InvalidUserException(activityRequest.getUserId());
    }
    Activity activity = activityDataMapper.activityRequestToActivityEntity(activityRequest);
    Activity savedActivity = activityRepository.save(activity);
    return activityDataMapper.activityEntityToActivityResponse(savedActivity);
  }
}
