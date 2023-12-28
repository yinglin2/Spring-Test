package com.spring.iocxml.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("6. bean对象创建完成，可以使用");
        System.out.println(user);
        applicationContext.close();
    }
}
