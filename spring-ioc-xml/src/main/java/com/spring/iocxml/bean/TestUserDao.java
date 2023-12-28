package com.spring.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据接口类型获取对应的bean
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }
}
