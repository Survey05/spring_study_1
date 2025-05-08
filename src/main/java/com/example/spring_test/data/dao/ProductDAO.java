package com.example.spring_test.data.dao;

import com.example.spring_test.data.entity.Product;

public interface ProductDAO {

    Product saveProduct(Product product);

    Product getProduct(String id);
}
