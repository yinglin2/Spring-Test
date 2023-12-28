package com.spring.iocxml.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
