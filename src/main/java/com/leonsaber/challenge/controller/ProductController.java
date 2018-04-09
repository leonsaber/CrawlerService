package com.leonsaber.challenge.controller;


import com.leonsaber.challenge.model.entity.Product;
import com.leonsaber.challenge.model.service.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product findOutOfStack(@PathVariable("id")int productID) {

        return productRepository.findProductByProductID(productID);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findAll() {
        return productRepository.findAllByOrderByProductIDAsc();
    }

    @RequestMapping(value = "/top10", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findTop10() {
        return productRepository.findTop10ByOrderByProductQtyAsc();
    }

    @RequestMapping(value = "/outOfStock", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findOutOfStack() {
        return productRepository.findOutOfStack();
    }

    @RequestMapping(value = "/priceAsc", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceAsc() {
        return productRepository.findAllByOrderByProductPriceAsc();
    }

    @RequestMapping(value = "/priceDesc", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceDesc() {
        return productRepository.findAllByOrderByProductPriceDesc();
    }

    @RequestMapping(value = "/priceRecommend={price}", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceRecommend(@PathVariable("price") double price) {
        return productRepository.findProductsByProductPrice(price);
    }

    @RequestMapping(value = "/lastOne", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceRecommend() {
        return productRepository.findProductsByProductQtyEqualsOne();
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    void deleteProduct(@PathVariable("id")int productID) {
        productRepository.deleteById(productID);
    }
}
