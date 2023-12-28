package com.spring.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Employee employee = applicationContext.getBean("emp", Employee.class);
        employee.work();

        Employee employee2 = applicationContext.getBean("emp2", Employee.class);
        employee2.work();

        Employee employee3 = applicationContext.getBean("emp3", Employee.class);
        employee3.work();

        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("bean-diarray.xml");
        Employee employee4 = applicationContext2.getBean("emp", Employee.class);
        employee4.work();
    }
}
