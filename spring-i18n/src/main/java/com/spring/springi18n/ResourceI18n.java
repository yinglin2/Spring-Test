package com.spring.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objects = new Object[] {"spring", new Date().toString()};
        String value = applicationContext.getMessage("test", objects, Locale.CHINA);
        System.out.println(value);
    }
}
