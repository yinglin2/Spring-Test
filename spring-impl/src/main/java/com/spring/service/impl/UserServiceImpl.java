package com.spring.service.impl;

import com.spring.anno.Bean;
import com.spring.anno.Di;
import com.spring.dao.UserDao;
import com.spring.service.UserService;

@Bean // @Service
public class UserServiceImpl implements UserService {
    @Di // @Autowired
    private UserDao userDao;


    @Override
    public void add() {
        System.out.println("service..........");
        userDao.add();
    }
}
