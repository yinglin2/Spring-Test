package com.spring.iocxml.lifecycle;

public class User {
    private String name;

    public User() {
        System.out.println("1. bean对象创建，调用无参数构造");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2. 给bean对象设置属性值");
    }

    // 初始化方法
    public void initMethod() {
        System.out.println("4. bean对象的初始化，调用指定的初始化方法");
    }

    //销毁方法
    public void destroyMethod() {
        System.out.println("7. bean对象的销毁，调用指定的销毁方法");
    }
}
