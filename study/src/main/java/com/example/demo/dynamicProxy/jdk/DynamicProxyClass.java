package com.example.demo.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyClass implements InvocationHandler {

    private Object subject;
    public DynamicProxyClass(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作(功能增强)
        System.out.println("before...");

        method.invoke(subject, args);

        //在代理真实对象后我们可以添加一些自己的操作(功能增强)
        System.out.println("after...");
        return null;
    }
}
