package com.spring.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-scope.xml");
        Order orders1 = applicationContext.getBean("orders", Order.class);
        System.out.println(orders1);

        Order orders2 = applicationContext.getBean("orders", Order.class);
        System.out.println(orders2);
    }
}
