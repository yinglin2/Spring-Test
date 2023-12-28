package com.spring.resource.controller;

import com.spring.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {
    @Resource(name = "myUserServiceImpl")
    private UserService userService;



    public void add() {
        System.out.println("UserController ....");
        userService.add();
    }
}
