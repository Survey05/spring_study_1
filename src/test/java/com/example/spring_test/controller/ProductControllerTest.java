package com.example.spring_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.spring_test.data.dto.ProductDto;
import com.example.spring_test.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

@Autowired private MockMvc mockMvc;

@MockBean ProductServiceImpl productService;

@Test
@DisplayName("Product 데이터 가져오기 테스트")
void getProduct() throws Exception {
    given(productService.getProduct("12315"))
        .willReturn(new ProductDto("15871", "pen", 5000, 2000));

    String productId = "12315";

    mockMvc
        .perform(get("/api/v1/product-api/product/" + productId))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").exists())
        .andExpect(jsonPath("$.productName").exists())
        .andExpect(jsonPath("$.productPrice").exists())
        .andExpect(jsonPath("$.productStock").exists())
        .andDo(print());

    verify(productService).getProduct("12315");
}

@Test
@DisplayName("Product 데이터 생성 테스트")
void createProduct() throws Exception {
    given(productService.saveProduct("15871", "pen", 5000, 2000))
        .willReturn(new ProductDto("15871", "pen", 5000, 2000));

    ProductDto productDto =
        ProductDto.builder().id("15871").name("pen").price(5000).stock(2000).build();
    Gson gson = new Gson();
    String content = gson.toJson(productDto);

    String json = new ObjectMapper().writeValueAsString(productDto);

    mockMvc
        .perform(
            post("/api/v1/product-api/product")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").exists())
        .andExpect(jsonPath("$.productName").exists())
        .andExpect(jsonPath("$.productPrice").exists())
        .andExpect(jsonPath("$.productStock").exists())
        .andDo(print());

    // saveProduct() 메서드 호출 확인
    verify(productService).saveProduct("15871", "pen", 5000, 2000);
}
}
