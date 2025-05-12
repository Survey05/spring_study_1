package com.example.spring_test.service;

import com.example.spring_test.data.dto.ProductDto;

public interface ProductService {

ProductDto saveProduct(String id, String name, int price, int stock);

ProductDto getProduct(String id);
}
