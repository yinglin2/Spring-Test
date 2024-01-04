package com.spring.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void testAdd() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.add(1, 2);
    }
}
