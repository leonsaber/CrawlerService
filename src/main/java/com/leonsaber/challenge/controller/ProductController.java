package com.leonsaber.challenge.controller;


import com.leonsaber.challenge.model.entity.Product;
import com.leonsaber.challenge.model.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping(path = "/product/all")
    public @ResponseBody
    Product getAllProducts() {
        return productRepository.findAllByProductNameNotNull();
    }
}
