package com.demo.service;

import com.demo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 17:55
 * @Version 1.0
 */
@Service
public class UserService {

    @Value("admin")
    private String userId;
    @Value("admin")
    private String userPassword;
    @Autowired
    private UserDAO userDAO;

    public void login() {
        System.out.println(userId + " login...");
    }
}
