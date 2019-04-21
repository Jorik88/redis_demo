package com.example.redis_demo.service;

import com.example.redis_demo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@CacheConfig(cacheManager = "secondManager")
@Slf4j
@Service
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product("1", "tv", "television"));
        products.add(new Product("2", "phone", "telephone"));
    }

    @Cacheable(cacheNames = "product")
    public Product getProduct(String id) {
        log.info("Get product by id in service, id={}", id);
        return products.stream()
                .filter(product -> id.equals(product.getId()))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("Product nit found"));
    }
}
