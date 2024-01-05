package com.spring.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;

//访问类路径下资源
public class ClassPathResourceDemo {
    public static void loadResource(String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);
        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.getDescription());

        try {
            // 读取文件内容
            InputStream inputStream = classPathResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        loadUrlResource("http://www.baidu.com");
        loadResource("testResourceFile.txt");
    }
}
