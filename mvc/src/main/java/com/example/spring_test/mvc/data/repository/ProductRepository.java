package com.example.spring_test.mvc.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_test.mvc.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

/*

List<Product> findByname(String name);

List<Product> queryByname(String name);

boolean existsByname(String name);

long countByname(String name);

void deleteByid(String id);
long removeByid(String id);

List<Product> findFirst5ByProductName(String name);
List<Product> findTop3ByProductName(String name);

Product findByProductIdIs(String id);
Product findByProductIdEquals(String id);

List<Product> findByProductIdNot(String id);
List<Product> findByProductIdIsNot(String id);

List<Product> findByProductStockIsNull();
List<Product> findByProductStockIsNotNull();

List<Product> findTopByProductIdAndProductName(String id, String name);

List<Product> findByProductPriceGreaterThan(Integer price);

List<Product> findByProductNameContaining(String name);


List <Product> findByProductNameContainingOrderByProductStockAsc(String name);
List <ProductEntity> findByProductNameContainingOrderByProductStockDesc(String name);

List<ProductEntity> findByProductNameContainingOrderByProductPriceAscProductStockDesc(String name);

List<ProductEntity> findByProductNameContaining(String name, Sort sort);

List<ProductEntity> findByProductPriceGreaterThan(Integer price, Pageable pageable);

*/

@Query("SELECT p FROM Product p WHERE p.price > 2000")
List<Product> findByPriceBasis();

@Query(value = "SELECT * FROM product p WHERE p.price > 2000", nativeQuery = true)
List<Product> findByPriceBasisNativeQuery();

@Query("SELECT p FROM Product p WHERE p.price > ?1")
List<Product> findByPriceWithParameter(Integer price);

@Query("SELECT p FROM Product p WHERE p.price > :price")
List<Product> findByPriceWithParameterNaming(Integer price);

@Query("SELECT p FROM Product p WHERE p.price > :pri")
List<Product> findByPriceWithParameterNaming2(@Param("pri") Integer price);

@Query(
    value = "SELECT * FROM product WHERE price > :price",
    countQuery = "SELECT count(*) FROM product WHERE price > ?1",
    nativeQuery = true)
List<Product> findByPriceWithParameterPaging(Integer price, Pageable pageable);
}
