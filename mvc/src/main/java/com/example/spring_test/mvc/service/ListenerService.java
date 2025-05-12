package com.example.spring_test.mvc.service;

import com.example.spring_test.mvc.data.entity.ListenerEntity;

public interface ListenerService {

ListenerEntity getEntity(Long id);

void saveEntity(ListenerEntity listenerEntity);

void updateEntity(ListenerEntity listenerEntity);

void removeEntity(ListenerEntity listenerEntity);
}
