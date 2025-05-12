package com.example.spring_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.spring_test.config.ProfileManager;
import com.example.spring_test.config.env.EnvConfiguration;

@SpringBootApplication
public class SpringTestApplication {

private final Logger LOGGER = LoggerFactory.getLogger(SpringTestApplication.class);

@Autowired
public SpringTestApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
    LOGGER.info(envConfiguration.getMessage());
    profileManager.printActiveProfiles();
}

public static void main(String[] args) {
    SpringApplication.run(SpringTestApplication.class, args);
}
}
