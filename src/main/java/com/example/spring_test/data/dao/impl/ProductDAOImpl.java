package com.example.spring_test.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_test.data.dao.ProductDAO;
import com.example.spring_test.data.entity.Product;
import com.example.spring_test.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

ProductRepository productRepository;

@Autowired
public ProductDAOImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

@Override
public Product saveProduct(Product product) {
    productRepository.save(product);
    return product;
}

@Override
public Product getProduct(String id) {
    Product product = productRepository.getById(id);
    return product;
}
}
