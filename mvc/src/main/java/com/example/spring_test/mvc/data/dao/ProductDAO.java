package com.example.spring_test.mvc.data.dao;

import com.example.spring_test.mvc.data.entity.Product;

public interface ProductDAO {

Product saveProduct(Product product);

Product getProduct(String id);
}
