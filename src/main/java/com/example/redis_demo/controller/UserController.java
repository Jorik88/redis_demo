package com.example.redis_demo.controller;

import com.example.redis_demo.model.User;
import com.example.redis_demo.service.IUserService;
import com.example.redis_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        log.info("Get user from controller, id={}", id);
        return userService.getUserById(id);
    }
}
