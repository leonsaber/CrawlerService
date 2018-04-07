package com.leonsaber.challenge.model.service;

import com.leonsaber.challenge.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByOrderByProductIDAsc();

    List<Product> findTop10ByOrderByProductQtyAsc();

    @Query(nativeQuery=true, value = "SELECT * FROM product p WHERE p.product_qty = 0")
    List<Product> findOutOfStack();

    List<Product> findAllByOrderByProductPriceAsc();

    List<Product> findAllByOrderByProductPriceDesc();

    Product findProductByProductID(int productID);
}
