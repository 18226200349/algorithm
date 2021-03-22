package com.example.demo.dynamicProxy.cglib;

public class HelloService {
    public HelloService() {
        System.out.println("HelloService构造方法");
    }

    /**
     * Cglib无法代理final修饰的方法
     */
    final public String sayOthers(String name) {
        System.out.println("cglib final method:" + name);
        return null;
    }

    public void sayHello(String name) {
        System.out.println("cglib normal method:"+ name);
    }
}
