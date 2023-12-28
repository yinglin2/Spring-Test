package com.spring.iocxml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {
    @Test
    public void demo1() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource = applicationContext.getBean("druidDataSource", DruidDataSource.class);
        System.out.println(druidDataSource.getUrl());

    }
}
