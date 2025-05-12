package com.example.spring_test.mvc.data.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import com.example.spring_test.mvc.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

@NotNull private String id;

@NotNull private String name;

@NotNull
@Min(value = 500)
@Max(value = 3000000)
private int price;

@NotNull
@Min(value = 0)
@Max(value = 9999)
private int stock;

public Product toEntity() {
    return Product.builder().id(id).name(name).price(price).stock(stock).build();
}
}
