package com.spring.bean;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.spring.anno.Bean;
import com.spring.anno.Di;

public class AnnotationApplicationContext implements ApplicationContext {
    // 创建map集合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    private String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 设置包扫描规则
    // 当前包以及其自曝，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage) {
        try {
            // 1. 把.替换成\
            String packagePath = basePackage.replaceAll("\\.", "/");
            // 2. 获取包绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                System.out.println(filePath);
                //获取包前面路径部分，字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                // 包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 属性注入
        loadDi();
    }

    // 包扫描过程，实例化
    private void loadBean(File file) throws Exception {
        // 1. 判断当前是否文件夹
        if (file.isDirectory()) {
            // 2. 获取文件夹里面所有内容
            File[] subFiles = file.listFiles();
            // 3. 判断文件夹里面为空
            if (subFiles == null || subFiles.length == 0) {
                return;
            }
            // 4. 如果文件夹里面不为空，遍历文件夹所有内容
            for (File subfile : subFiles) {
                // 4.1 遍历的到每个File对象，继续判断，如果还是文件，递归
                if (subfile.isDirectory()) {
                    // 递归
                    loadBean(subfile);
                } else {
                    // 4.2 遍历的到的File对象不是文件夹，是文件
                    // 4.3 得到包路径+类名称部分-字符串截取
                    String pathWithClass = subfile.getAbsolutePath().substring(rootPath.length());
                    // 4.4 判断当前文件类型是否.class
                    if (pathWithClass.contains(".class")) {
                        // 4.5 如果是.class类型，把路径\替换成.， 把.class去掉
                        String path = pathWithClass.replaceAll("/", ".")
                                .replace(".class", "");
                        // 4.6 判断类上面是否有注解@Bean, 如果有实例化过程
                        // 4.6.1 获取类的class
                        Class<?> clazz = Class.forName(path);
                        // 4.6.2 判断是不是接口
                        if (!clazz.isInterface()) {
                            // 4.6.3 判断类上面是否有注解 @Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                // 4.6.4 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.7 把对象实例化之后，放到map集合beanFactory
                                // 4.7.1 判断当前类如果有接口，让接口class作为map的key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 属性注入
    private void loadDi() {
        // 实例化对象在beanFactory的map集合里面
        // 1. 遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            // 2. 获取map集合每个对象（value），每个对象属性获取到
            Object object = entry.getValue();
            // 获取对象Class
            Class<?> clazz = object.getClass();
            // 获取每个对象属性
            Field[] declaredFields = clazz.getDeclaredFields();

            // 3. 遍历得到的每个对象属性数组，得到每个属性
            for (Field field : declaredFields) {
                // 4. 判断属性上面是否是有@Di注解
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null) {
                    // 如果私有属性，可以设置值
                    field.setAccessible(true);
                    // 5. 如果有@Di注解，把对象进行设置
                    try {
                        field.set(object, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }
}
