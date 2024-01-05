package com.spring.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;

public class FileSystemResourceDemo {
    public static void loadFileResource(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        System.out.println(fileSystemResource.getFilename());
        System.out.println(fileSystemResource.getDescription());

        try {
            // 读取文件内容
            InputStream inputStream = fileSystemResource.getInputStream();
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
        loadFileResource("testResourceFile.txt");
    }
}
