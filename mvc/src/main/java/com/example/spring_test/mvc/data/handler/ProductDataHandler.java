package com.example.spring_test.mvc.data.handler;

import com.example.spring_test.mvc.data.entity.Product;

public interface ProductDataHandler {

Product saveProduct(String id, String name, int price, int stock);

Product getProduct(String id);
}
