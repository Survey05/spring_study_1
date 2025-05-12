package com.example.spring_test.mvc.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Hidden
@RestControllerAdvice
public class SpringTestExceptionHandler {

private final Logger LOGGER = LoggerFactory.getLogger(SpringTestExceptionHandler.class);

@ExceptionHandler(value = Exception.class)
public ResponseEntity<Map<String, String>> handleException(Exception e) {

    LOGGER.info("Advice 내 ExceptionHandler 호출");

    Map<String, String> map = new HashMap<>();
    map.put("error type", HttpStatus.BAD_REQUEST.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "에러 발생");

    return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(value = com.example.spring_test.mvc.common.exception.SpringTestException.class)
public ResponseEntity<Map<String, String>> ExceptionHandler(SpringTestException e) {
    HttpHeaders responseHeaders = new HttpHeaders();

    Map<String, String> map = new HashMap<>();
    map.put("error type", HttpStatus.BAD_REQUEST.getReasonPhrase());
    map.put("error code", Integer.toString(e.getHttpStatusCode()));
    map.put("message", e.getMessage());

    return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
}
}
