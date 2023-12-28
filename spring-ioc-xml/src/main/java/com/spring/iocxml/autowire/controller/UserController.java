package com.spring.iocxml.autowire.controller;

import com.spring.iocxml.autowire.service.UserService;

public class UserController {
    private UserService userService;
    public void addUser() {
        System.out.println("Controller方法执行了");
        userService.addUserService();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
