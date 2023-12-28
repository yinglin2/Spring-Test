package com.spring.resource.service;

import com.spring.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myUserServiceImpl")
public class UserServiceImpl implements UserService {

    // 按照名称
//    @Resource(name = "myUserDaoImpl")
//    private UserDao userDao;

    // 按照类型
    @Resource
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("UserService add ........");
        userDao.add();
    }
}
