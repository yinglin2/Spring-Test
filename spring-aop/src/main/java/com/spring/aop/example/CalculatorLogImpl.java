package com.spring.aop.example;

/**
 * 具有日志功能的计算器
 */
public class CalculatorLogImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是:" + i + "," + j);
        int res = i + j;
        System.out.println("方法内部 result = " + res);
        System.out.println("[日志] add 方法结束了，结果是:" + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是:" + i + "," + j);
        int res = i - j;
        System.out.println("方法内部 result = " + res);
        System.out.println("[日志] sub 方法结束了，结果是:" + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是:" + i + "," + j);
        int res = i * j;
        System.out.println("方法内部 result = " + res);
        System.out.println("[日志] mul 方法结束了，结果是:" + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是:" + i + "," + j);
        int res = i / j;
        System.out.println("方法内部 result = " + res);
        System.out.println("[日志] div 方法结束了，结果是:" + res);
        return res;
    }
}
