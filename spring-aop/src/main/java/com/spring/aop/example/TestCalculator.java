package com.spring.aop.example;

public class TestCalculator {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator calculator = (Calculator) proxyFactory.getProxy();
        calculator.add(1, 2);

    }
}
