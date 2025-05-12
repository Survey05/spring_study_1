package com.example.spring_test.mvc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_test.mvc.data.entity.ListenerEntity;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {}
