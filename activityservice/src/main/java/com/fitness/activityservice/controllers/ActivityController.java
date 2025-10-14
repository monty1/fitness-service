package com.fitness.activityservice.controllers;

import com.fitness.activityservice.dtos.ActivityRequestDto;
import com.fitness.activityservice.dtos.ActivityResponseDto;
import com.fitness.activityservice.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @PostMapping("/track")
  public ResponseEntity<ActivityResponseDto> trackUserActivity(@RequestBody
                                                               ActivityRequestDto activityRequest) {
    ActivityResponseDto activityResponseDto = activityService.trackActivity(activityRequest);
    return ResponseEntity.ok(activityResponseDto);
  }

}
