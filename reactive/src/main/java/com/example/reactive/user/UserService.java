package com.example.reactive.user;

import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

  private final Map<Long, User> users =
      new HashMap<>(
          Map.of(
              1L,
              User.builder().id(1L).name("spring").age(20).build(),
              2L,
              User.builder().id(2L).name("test").age(21).build(),
              3L,
              User.builder().id(3L).name("pro").age(22).build(),
              4L,
              User.builder().id(4L).name("ject").age(23).build()));

  public Flux<User> getAllUsers() {
    return Flux.fromStream(users.values().stream());
  }

  public Mono<User> getUserById(Long id) {
    return Mono.just(users.get(id));
  }
}
