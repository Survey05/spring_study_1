package com.example.spring_test.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.spring_test.mvc.Application;

@Component
public class ProfileManager {

private final Logger LOGGER = LoggerFactory.getLogger(Application.class);
private final Environment environment;

@Autowired
public ProfileManager(Environment environment) {
    this.environment = environment;
}

public void printActiveProfiles() {
    LOGGER.info(
        "[printActiveProfiles] active Profiles size : {}", environment.getActiveProfiles().length);
    for (String profile : environment.getActiveProfiles()) {
    LOGGER.info("[printActiveProfiles] Profile : {}", profile);
    }
}
}
