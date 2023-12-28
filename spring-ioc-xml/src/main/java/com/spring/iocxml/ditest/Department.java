package com.spring.iocxml.ditest;

import java.util.List;

public class Department {
    private String dname;
    private List<Employee> employeeList;
    public void info() {
        System.out.println("department name: " + dname);
        for (Employee employee : employeeList) {
            System.out.println(employee.getEname());
        }
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
