package com.example.spring_test.service.impl;

import com.example.spring_test.data.dto.ProductDto;
import com.example.spring_test.data.entity.Product;
import com.example.spring_test.data.handler.ProductDataHandler;
import com.example.spring_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String id, String name, int price, int stock) {
        Product product = productDataHandler.saveProduct(id, name, price, stock);

        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());

        return productDto;

    }

    @Override
    public ProductDto getProduct(String id) {
        Product product = productDataHandler.getProduct(id);

        ProductDto productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());

        return productDto;

    }

}
