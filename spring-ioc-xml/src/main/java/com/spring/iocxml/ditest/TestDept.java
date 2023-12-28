package com.spring.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {
    public static void main(String[] args) {
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Department department = applicationContext2.getBean("dept", Department.class);
        department.info();
    }
}
