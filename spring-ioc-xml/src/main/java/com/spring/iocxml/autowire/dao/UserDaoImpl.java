package com.spring.iocxml.autowire.dao;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUserDao() {
        System.out.println("userDao 方法执行了");
    }
}
