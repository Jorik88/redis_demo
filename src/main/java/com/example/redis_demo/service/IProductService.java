package com.example.redis_demo.service;

import com.example.redis_demo.model.Product;

public interface IProductService {

    Product getProduct(String id);
}
