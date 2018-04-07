package com.leonsaber.challenge.model.service;

import com.leonsaber.challenge.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Product findAllByProductNameNotNull();
}
