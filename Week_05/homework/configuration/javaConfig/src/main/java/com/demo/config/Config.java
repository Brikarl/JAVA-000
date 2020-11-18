package com.demo.config;

import com.demo.dao.UserDAO;
import com.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 18:44
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.demo")
public class Config {
    @Bean
    public UserDAO userDAO() {
        UserDAO userDAO = new UserDAO();
        System.out.println("已创建" + userDAO);
        return userDAO;
    }

    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        System.out.println("已创建" + userService);
        return userService;
    }
}
