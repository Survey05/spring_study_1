package com.example.spring_test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Httpinterceptor implements HandlerInterceptor {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    LOGGER.info("[preHandle] preHandle is performed");
    /*
    LOGGER.info("[preHandle] request : {}", request);
    LOGGER.info("[preHandle] request path info : {}", request.getPathInfo());
    LOGGER.info("[preHandle] request header names : {}", request.getHeaderNames());
    LOGGER.info("[preHandle] request request URL : {}", request.getRequestURL());
    LOGGER.info("[preHandle] request request URI : {}", request.getRequestURI());
    LOGGER.info("[preHandle] request Requested Session : {}", request.getRequestedSessionId());
     */

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    LOGGER.info("[postHandle] postHandle is performed");
    LOGGER.info("[postHandle] request : {}", request);
    LOGGER.info("[postHandle] response : {}", response);
    LOGGER.info("[postHandle] response : {}", response.getHeaderNames());
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    LOGGER.info("[afterCompletion] afterCompletion is performed");
  }

}
