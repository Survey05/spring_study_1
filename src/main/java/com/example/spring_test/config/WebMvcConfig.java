package com.example.spring_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.spring_test.interceptor.Httpinterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(new Httpinterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/hello");
}
}
