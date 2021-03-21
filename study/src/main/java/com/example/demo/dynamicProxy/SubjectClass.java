package com.example.demo.dynamicProxy;

/**
 * 代理对象
 */
public class SubjectClass implements SubjectInterface{
    @Override
    public void hello(String name) {
        System.out.println("动态代理："+ name);
    }
}
