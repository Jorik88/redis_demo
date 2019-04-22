package com.example.redis_demo.service;

import com.example.redis_demo.model.User;

public interface IUserService {

    User getUserById(String id);
}
