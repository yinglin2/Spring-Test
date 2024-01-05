package com.spring.validator.three;

import org.aspectj.lang.annotation.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService myService = applicationContext.getBean(MyService.class);
        User user = new User();
        user.setName("Lucy");
        user.setPhone("3434235425");
        myService.testParams(user);
    }
}
