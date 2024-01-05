package com.spring.prefix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {
    public static void main(String[] args) {
        /**
         * 通过搜索文件系统路径下的xml文件创建ApplicationContext，
         * 但通过指定classpath:前缀强制搜索类加载路径
         * classpath:bean.xml
         *
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        Resource resource = context.getResource("testResourceFile.txt");
        System.out.println(resource.getDescription());
    }
}
