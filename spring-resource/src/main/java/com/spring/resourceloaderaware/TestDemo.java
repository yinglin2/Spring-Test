package com.spring.resourceloaderaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        TestBean testBean = applicationContext.getBean(TestBean.class);
        ResourceLoader resourceLoader = testBean.getResourceLoader();

        System.out.println(applicationContext == resourceLoader);
    }
}
