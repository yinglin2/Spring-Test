package com.spring.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * ResourceLoader: 该接口实现类的实例可以获得一个Resource实例
 *
 * Resource getResource(String location) : 该接口仅有这个方法，用于返回一个Resource实例。
 * ApplicationContext实现类都实现ResourceLoader接口，因此ApplicationContext可直接获取Resource实例。
 */
public class ResourceLoaderDemo {
    @Test
    public void demo() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("testResourceFile.txt");
        System.out.println(resource.getFilename());
    }

    @Test
    public void demo2() {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("testResourceFile.txt");
        System.out.println(resource.getFilename());
    }
}
