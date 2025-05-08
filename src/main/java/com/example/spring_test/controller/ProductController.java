package com.example.spring_test.controller;

import com.example.spring_test.common.Constants;
import com.example.spring_test.common.exception.SpringTestException;
import com.example.spring_test.data.dto.ProductDto;
import com.example.spring_test.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService ProductService){
        this.productService = ProductService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String id){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Test API.", "getProduct");

        ProductDto productDto = productService.getProduct(id);

        LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms"
                , productDto.getId(), productDto.getName(), productDto.getPrice(), productDto.getStock(), System.currentTimeMillis() - startTime);
        return productDto;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){

        String id = productDto.getId();
        String name = productDto.getName();
        int price = productDto.getPrice();
        int stock = productDto.getStock();

        ProductDto response = productService.saveProduct(id, name, price, stock);

        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {} productStock : {} "
                , response.getId(), response.getName(), response.getPrice(), response.getStock());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId){ return null; }


    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws SpringTestException{
        throw new SpringTestException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
    }

    @GetMapping(value = "/hello")
    public String getHello() {
        return "hello World";
    }
}
