package com.fitness.activityservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
public class TimeZoneConfig {

    @PostConstruct
    public void init() {
        // Set JVM timezone to UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("JVM timezone set to: " + TimeZone.getDefault().getID());
    }
}

