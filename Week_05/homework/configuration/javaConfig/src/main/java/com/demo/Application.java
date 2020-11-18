package com.demo;

import com.demo.config.Config;
import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 17:34
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.login();
    }
}
