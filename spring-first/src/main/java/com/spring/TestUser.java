package com.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 如何使用反射创建对象？
 * 1. 加载bean.xml配置文件
 * 2. 对xml文件进行解析
 * 3. 获取xml文件bean标签属性值（id和class）
 * 4. 使用反射根据类全路径创建对象
 * 5. 对象存放的位置：
 *          DefaultListableBeanFactory
 *          Map<String, BeanDefinition> beanDefinitionMap: Key: 唯一标识， Value: 类的定义（描述信息）
 */

public class TestUser {
    // 创建Logger对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);
    @Test
    public void testUserObject() {
        // 加载Spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建对象
        User user = (User) context.getBean("user");
        System.out.println(user);
        // 使用对象调用方法进行测试
        user.add();

        // 手动写日志
        logger.info("### 执行调用成功了...");
    }

    // 反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        // 获取类Class对象
        Class clazz = Class.forName("com.spring.User");
        // 调用方法创建对象
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
