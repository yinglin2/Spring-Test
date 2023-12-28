package com.spring.iocxml.autowire;

import com.spring.iocxml.autowire.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowire.xml");
        UserController userController = applicationContext.getBean("userController", UserController.class);
        userController.addUser();
    }
}
