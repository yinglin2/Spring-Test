package com.spring.iocxml.dimap;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStu {

    @Test
    public void testStu() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-dimap.xml");
        Student student = applicationContext.getBean("student", Student.class);
        student.run();
    }

    @Test
    public void testStu2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = applicationContext.getBean("student", Student.class);
        student.run();

        Student studentp = applicationContext.getBean("studentp", Student.class);
        studentp.run();
    }
}
