package com.example.redis_demo.controller;

import com.example.redis_demo.model.Product;
import com.example.redis_demo.service.IProductService;
import com.example.redis_demo.service.impl.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable String id) {
        log.info("Try get product by id={}", id);
        return productService.getProduct(id);
    }
}
