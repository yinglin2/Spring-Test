package com.spring.dao.impl;

import com.spring.anno.Bean;
import com.spring.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao...............");
    }
}
