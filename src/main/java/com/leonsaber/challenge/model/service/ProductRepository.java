package com.leonsaber.challenge.model.service;

import com.leonsaber.challenge.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByOrderByProductIDAsc();

    @Modifying
    @Query(nativeQuery=true, value = "SELECT * FROM (SELECT * FROM product WHERE product_qty > 0) p ORDER BY p.product_qty ASC LIMIT 10; ")
    List<Product> findTop10ByOrderByProductQtyAsc();

    @Modifying
    @Query(nativeQuery=true, value = "SELECT * FROM product p WHERE p.product_qty = 0")
    List<Product> findOutOfStack();

    List<Product> findAllByOrderByProductPriceAsc();

    List<Product> findAllByOrderByProductPriceDesc();

    Product findProductByProductID(int productID);

    @Query(nativeQuery=true, value = "SELECT * FROM product p WHERE p.product_price >= abs(?1 - 0.5) AND p.product_price <= ?1 + 0.5")
    List<Product> findProductsByProductPrice(double productPrice);

    @Query(nativeQuery=true, value = "SELECT * FROM product p WHERE p.product_qty = 1")
    List<Product> findProductsByProductQtyEqualsOne();

    void deleteById(int productID);
}
