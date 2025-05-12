package com.example.spring_test.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Profile("local")
@Configuration
public class LocalConfiguration implements EnvConfiguration {

private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

@Value("${spring.test.loading.message}")
private String message;

@Override
@Bean
public String getMessage() {
    LOGGER.info("[getMessage] LocalConfiguration 입니다.");
    return message;
}
}
