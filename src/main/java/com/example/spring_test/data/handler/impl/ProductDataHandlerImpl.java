package com.example.spring_test.data.handler.impl;

import com.example.spring_test.data.dao.ProductDAO;
import com.example.spring_test.data.entity.Product;
import com.example.spring_test.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProduct(String id, String name, int price, int stock) {
        Product product = new Product(id, name, price, stock);

        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProduct(String id) {
        return productDAO.getProduct(id);
    }

}
