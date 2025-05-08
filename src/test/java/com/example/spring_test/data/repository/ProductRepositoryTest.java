package com.example.spring_test.data.repository;

import com.example.spring_test.data.entity.Product;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @BeforeEach
  void GenerateDate() {
   int count =  1;
   productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
   productRepository.save(getProduct(Integer.toString(count), count++, 3000, 9000));
   productRepository.save(getProduct(Integer.toString(--count), count = count + 2, 1500, 200));
   productRepository.save(getProduct(Integer.toString(count), count++, 4000, 5000));
   productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
   productRepository.save(getProduct(Integer.toString(count), count++, 1000, 1000));
   productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
   productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
   productRepository.save(getProduct(Integer.toString(count), count++, 7200, 2000));
   productRepository.save(getProduct(Integer.toString(count), count++, 5100, 1700));
  }

  private Product getProduct(String id, int nameNuber, int price, int stock) {
    return new Product(id, "상품" + nameNuber, price, stock);
  }

  /*
  @Test
  void findTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for(ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundEntities = productRepository.findByProductName("상품4");

    for(ProductEntity productEntity : foundEntities) {
      System.out.println(productEntity.toString());
    }

    List<ProductEntity> queryEntities = productRepository.queryByProductName("상품4");

    for(ProductEntity productEntity : queryEntities) {
      System.out.println(productEntity.toString());
    }
  }

  @Test
  void existTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for(ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.existsByProductName("상품4"));
    System.out.println(productRepository.existsByProductName("상품2"));
  }

  @Test
  void countTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.countByProductName("상품4"));
  }

  @Test
  @Transactional
  void deleteTest() {
    System.out.println("before : " + productRepository.count());

    productRepository.deleteByProductId("1");
    productRepository.removeByProductId("9");

    System.out.println("after : " + productRepository.count());
  }

  @Test
  void topTest() {
    productRepository.save(getProduct("100", 123, 1500, 5000));
    productRepository.save(getProduct("101", 123, 2500, 5000));
    productRepository.save(getProduct("102", 123, 3500, 5000));
    productRepository.save(getProduct("103", 123, 4500, 5000));
    productRepository.save(getProduct("104", 123, 1000, 5000));
    productRepository.save(getProduct("105", 123, 2000, 5000));
    productRepository.save(getProduct("106", 123, 3000, 5000));
    productRepository.save(getProduct("107", 123, 4000, 5000));

    List<ProductEntity> foundEntities = productRepository.findFirst5ByProductName("상품123");
    for(ProductEntity productEntity : foundEntities) {
      System.out.println(productEntity.toString());
    }

    List<ProductEntity> foundEntities2 = productRepository.findTop3ByProductName("상품123");
    for(ProductEntity productEntity : foundEntities2) {
      System.out.println(productEntity.toString());
    }
  }

  @Test
  void isEqualsTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.findByProductIdIs("1"));
    System.out.println(productRepository.findByProductIdEquals("1"));
  }

  @Test
  void notTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundEntities = productRepository.findByProductIdNot("1");
    for(ProductEntity productEntity : foundEntities) {
      System.out.println(productEntity);
    }
    System.out.println(productRepository.findByProductIdIsNot("1"));
  }

  @Test
  void nullTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.findByProductStockIsNull());
    System.out.println(productRepository.findByProductStockIsNotNull());
  }

  @Test
  void andTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.findTopByProductIdAndProductName("1", "상품1"));
  }

  @Test
  void greaterTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> productEntities = productRepository.findByProductPriceGreaterThan(5000);

    for (ProductEntity productEntity : productEntities) {
      System.out.println(productEntity);
    }
  }

  @Test
  void containTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    System.out.println(productRepository.findByProductNameContaining("상품1"));
  }


  @Test
  void orderByTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundProducts = productRepository.findByProductNameContainingOrderByProductStockAsc("상품");
    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }

    foundProducts = productRepository.findByProductNameContainingOrderByProductStockDesc("상품");
    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }

 }

  @Test
  void multiOrderByTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundProducts = productRepository.findByProductNameContainingOrderByProductPriceAscProductStockDesc("상품");

    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }
  }

  @Test
  void orderByWithParameterTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundProducts = productRepository.findByProductNameContaining("상품", Sort.by(
        Order.asc("productPrice")));

    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }

    foundProducts = productRepository.findByProductNameContaining("상품", Sort.by(Order.asc("productPrice")));
    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }
  }

  @Test
  void pagingTest() {
    List<ProductEntity> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (ProductEntity productEntity : foundAll) {
      System.out.println(productEntity.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<ProductEntity> foundProducts = productRepository.findByProductPriceGreaterThan(200, PageRequest.of(0, 2));

    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }

    foundProducts = productRepository.findByProductPriceGreaterThan(200, PageRequest.of(2, 2));
    for (ProductEntity productEntity : foundProducts) {
      System.out.println(productEntity);
    }

  }

   */

  @Test
  public void queryTest() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceBasis();
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

  @Test
  public void nativeQueryTest() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceBasisNativeQuery();
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

  @Test
  public void parameterQueryTest() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceWithParameter(2000);
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

  @Test
  public void parameterNamingQueryTest() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceWithParameterNaming(2000);
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

  @Test
  public void parameterNamingQueryTest2() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceWithParameterNaming2(2000);
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

  @Test
  public void nativeQueryPagingTest2() {
    List<Product> foundAll = productRepository.findAll();
    System.out.println("====↓↓ Test Data ↓↓====");
    for (Product product : foundAll) {
      System.out.println(product.toString());
    }
    System.out.println("===↑↑ Test Data ↑↑====");

    List<Product> foundProducts = productRepository.findByPriceWithParameterPaging(2000,
        PageRequest.of(2, 2));
    for (Product product : foundProducts) {
      System.out.println(product);
    }
  }

}

