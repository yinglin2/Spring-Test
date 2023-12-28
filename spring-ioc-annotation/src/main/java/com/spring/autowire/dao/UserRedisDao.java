package com.spring.autowire.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDao implements UserDao {

    @Override
    public void add() {
        System.out.println("User redis dao");
    }
}
