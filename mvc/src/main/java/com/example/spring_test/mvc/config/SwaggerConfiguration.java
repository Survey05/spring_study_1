package com.example.spring_test.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {

@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Test Project API").description("Test Project").version("1.0.0"))
        .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
        .schemaRequirement(
            "Bearer Authentication",
            new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT"));
}
}
