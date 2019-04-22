package com.example.redis_demo.service;

import com.example.redis_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@CacheConfig(cacheManager = "firstManager")
@Slf4j
@Service
public class UserService implements IUserService{

    private List<User> users;

    @PostConstruct
    public void init() {
        users = Arrays.asList(new User("1", "Vova"), new User("2", "Jora"));
    }

    @Cacheable(cacheNames = "users")
    @Override
    public User getUserById(String id) {
        log.info("Try get user by id={}", id);
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Can't fid user by id"));
    }
}
