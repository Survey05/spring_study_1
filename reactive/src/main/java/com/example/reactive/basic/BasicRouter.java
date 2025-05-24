package com.example.reactive.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.reactive.user.User;

@Configuration
public class BasicRouter {

  @Bean
  public RouterFunction<ServerResponse> BasicRoute() {
    return RouterFunctions.route()
        .GET("/api/router/hello", request -> ServerResponse.ok().bodyValue("Hello, Spring_test!"))
        .GET(
            "/api/router/hello/{name}",
            request -> {
              String name = request.pathVariable("name");
              return ServerResponse.ok().bodyValue("Hello, " + name + "!");
            })
        .GET(
            "/api/router/greet",
            request -> {
              String name = request.queryParam("name").orElse("Guest");
              return ServerResponse.ok().bodyValue("Hello, " + name + "!");
            })
        .GET(
            "/api/router/check-header",
            request -> {
              String requestId = request.headers().firstHeader("X-Request-Id");
              String response =
                  (requestId == null) ? "No Request Id found" : "Request Id: " + requestId;
              return ServerResponse.ok().bodyValue(response);
            })
        .POST(
            "/api/router/create",
            request ->
                request
                    .bodyToMono(User.class)
                    .flatMap(
                        user -> ServerResponse.ok().bodyValue("User Created: " + user.getName())))
        .build();
  }
}
