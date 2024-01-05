package com.spring.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMethod {
    @Test
    public void testMyValidation1() {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 myService = context.getBean(MyValidation1.class);
        User user = new User();
        user.setAge(-1);
        boolean validator = myService.validateUser(user);
        System.out.println(validator);
    }

    @Test
    public void testMyValidation2() {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 myService = context.getBean(MyValidation2.class);
        User user = new User();
        user.setAge(-1);
        boolean validator = myService.validateUser(user);
        System.out.println(validator);
    }
}
