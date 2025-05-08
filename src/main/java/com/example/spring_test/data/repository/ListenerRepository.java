package com.example.spring_test.data.repository;

import com.example.spring_test.data.entity.ListenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {

}
