package com.leonsaber.challenge.controller;


import com.leonsaber.challenge.model.entity.Product;
import com.leonsaber.challenge.model.service.ProductRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value="find product by", notes="get all product data from product' ID")
    @ApiImplicitParam(name = "findProductByID", value = "all product' information", required = true, dataType = "User")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product findProductByID(@PathVariable("id")int productID) {

        return productRepository.findProductByProductID(productID);
    }

    @ApiOperation(value="Get All Products", notes="gGet all products data and create products list")
    @ApiImplicitParam(name = "findAll", value = "get All Products", required = true, dataType = "User")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findAll() {
        return productRepository.findAllByOrderByProductIDAsc();
    }

    @ApiOperation(value="top 10 product' data", notes="find Top10 product and product qty greater than 1")
    @ApiImplicitParam(name = "finalTop10", value = "top 10 product' data", required = true, dataType = "User")
    @RequestMapping(value = "/top10", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findTop10() {
        return productRepository.findTop10ByOrderByProductQtyAsc();
    }

    @ApiOperation(value="find out of stock", notes="find out of stock product, when qty equal 0")
    @ApiImplicitParam(name = "finalOutOfStack", value = "find out of stock", required = true, dataType = "User")
    @RequestMapping(value = "/outOfStock", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findOutOfStack() {
        return productRepository.findOutOfStack();
    }

    @ApiOperation(value="price ascending", notes="show all products in ascending order")
    @ApiImplicitParam(name = "findPriceAsc", value = "price ascending", required = true, dataType = "User")
    @RequestMapping(value = "/priceAsc", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceAsc() {
        return productRepository.findAllByOrderByProductPriceAsc();
    }

    @ApiOperation(value="price descending", notes="show all products in descending order")
    @ApiImplicitParam(name = "findPriceDesc", value = "price descending", required = true, dataType = "User")
    @RequestMapping(value = "/priceDesc", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceDesc() {
        return productRepository.findAllByOrderByProductPriceDesc();
    }

    @ApiOperation(value="Recommended Products", notes="show all products in product' price in range +/- 1")
    @ApiImplicitParam(name = "findPriceRecommend", value = "price descending", required = true, dataType = "User")
    @RequestMapping(value = "/priceRecommend={price}", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findPriceRecommend(@PathVariable("price") double price) {
        return productRepository.findProductsByProductPrice(price);
    }

    @ApiOperation(value="find product qty equal 1", notes="show product data which qty equal 1")
    @ApiImplicitParam(name = "findLastOneQty", value = "find product qty equal 1", required = true, dataType = "User")
    @RequestMapping(value = "/lastOne", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> findLastOneQty() {
        return productRepository.findProductsByProductQtyEqualsOne();
    }
    @ApiOperation(value="delete product data by product id", notes="through product id delete product data from data base")
    @ApiImplicitParam(name = "deleteProduct", value = "delete product data by product id", required = true, dataType = "Admin")
    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    void deleteProduct(@PathVariable("id")int productID) {
        productRepository.deleteById(productID);
    }
}
