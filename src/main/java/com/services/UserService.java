package com.services;

import com.repository.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);
    User findByUserName(String userName);
}
