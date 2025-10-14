package com.fitness.activityservice.mappers;

import com.fitness.activityservice.dtos.ActivityRequestDto;
import com.fitness.activityservice.dtos.ActivityResponseDto;
import com.fitness.activityservice.models.Activity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityDataMapper {

  ActivityResponseDto activityEntityToActivityResponse(Activity activity);

  Activity activityRequestToActivityEntity(ActivityRequestDto activityRequestDto);
}
