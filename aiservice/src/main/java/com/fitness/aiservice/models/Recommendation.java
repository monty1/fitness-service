package com.fitness.aiservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "recommendations")
@Data
public class Recommendation {
  @Id
  private String id;
  private String activityId;
  private String userId;
  private String recommendation;
  private List<String> improvements;
  private List<String> suggestions;
  private List<String> safety;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
