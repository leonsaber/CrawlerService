package com.leonsaber.challenge.controller;


import com.leonsaber.challenge.model.entity.Product;
import com.leonsaber.challenge.model.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/product/{id}")
    public @ResponseBody
    Product findOutOfStack(@PathVariable("id")int productID) {
        return productRepository.findProductByProductID(productID);
    }

    @GetMapping(path = "/product/all")
    public @ResponseBody
    List<Product> findAll() {
        return productRepository.findAllByOrderByProductIDAsc();
    }

    @GetMapping(path = "/product/top-10")
    public @ResponseBody
    List<Product> findTop10() {
        return productRepository.findTop10ByOrderByProductQtyAsc();
    }

    @GetMapping(path = "/product/out-of-stack")
    public @ResponseBody
    List<Product> findOutOfStack() {
        return productRepository.findOutOfStack();
    }

    @GetMapping(path = "/product/price-asc")
    public @ResponseBody
    List<Product> findPriceAsc() {
        return productRepository.findAllByOrderByProductPriceAsc();
    }

    @GetMapping(path = "/product/price-desc")
    public @ResponseBody
    List<Product> findPriceDesc() {
        return productRepository.findAllByOrderByProductPriceDesc();
    }
}
