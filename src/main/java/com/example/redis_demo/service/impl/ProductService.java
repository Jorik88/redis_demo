package com.example.redis_demo.service.impl;

import com.example.redis_demo.model.Product;
import com.example.redis_demo.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheManager = "secondManager")
@Slf4j
@Service
public class ProductService implements IProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("1", "tv", "television"));
        products.add(new Product("2", "phone", "telephone"));
    }

    @Cacheable(cacheNames = "product")
    @Override
    public Product getProduct(String id) {
        log.info("Get product by id in service, id={}", id);
        return products.stream()
                .filter(product -> id.equals(product.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
