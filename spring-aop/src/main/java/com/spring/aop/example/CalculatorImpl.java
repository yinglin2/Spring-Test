package com.spring.aop.example;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int res = i + j;
        System.out.println("方法内部 result = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        System.out.println("方法内部 result = " + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        System.out.println("方法内部 result = " + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        System.out.println("方法内部 result = " + res);
        return res;
    }
}
