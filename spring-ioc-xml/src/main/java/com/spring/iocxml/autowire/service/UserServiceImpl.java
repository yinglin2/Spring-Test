package com.spring.iocxml.autowire.service;

import com.spring.iocxml.autowire.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void addUserService() {
        System.out.println("UserService方法执行了.......");
        userDao.addUserDao();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
