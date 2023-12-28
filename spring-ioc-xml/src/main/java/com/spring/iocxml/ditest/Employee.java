package com.spring.iocxml.ditest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee {
    private String ename;
    private Integer age;

    private Department department;

    private String[] hobbies;

    public void work() {
        System.out.println(ename + age + ":"+ "Working.....");
        department.info();
        System.out.println(Arrays.toString(hobbies));
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEname() {
        return ename;
    }

    public Integer getAge() {
        return age;
    }

    public Department getDepartment() {
        return department;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
