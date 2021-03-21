package com.example.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientClass {
    public static void main(String[] args) {
        //被代理类
        SubjectClass subjectClass = new SubjectClass();
        //InvocationHandler接口类型的动态代理类
        InvocationHandler handler = new DynamicProxyClass(subjectClass);

        /**
         * 通过Proxy的newProxyInstance方法来创建动态代理类：
         * 第一个参数：类加载器,用来加载动态代理类
         * 第二个参数：动态代理类需要实现的接口
         * 第三个参数：动态代理方法在执行时，会调用handler里面的invoke方法去执行
         *
         * 为什么我们可以将动态代理对象强转为SubjectInterface接口类型？
         * 原因就是在newProxyInstance这个方法的第二个参数"Class<?>[] interfaces"上，我们给这个代理对象提供了一组什么接口，
         * 那么这个代理对象就会宣称实现了这组接口，这个时候我们就可以将这个代理对象强转为这组接口中的任意一个类型。
         */
        SubjectInterface subjectInterface = (SubjectInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader()
                ,subjectClass.getClass().getInterfaces(), handler);

        /**
         * 输出为：$Proxy0
         * 为什么是$Proxy0 ?
         * 因为通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，
         * 它既不是我们的InvocationHandler类型，也不是我们定义的 subjectInterface 接口的类型，
         * 而是在运行时动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
         * */
        System.out.println(subjectInterface.getClass().getName());

        /**
         * 方法调用
         * 原理：通过 subjectInterface 调用接口中的方法，程序就会跳转到这个代理对象关联到的 handler 中的invoke方法去执行，
         * 而我们的这个 handler 对象又接收了一个 subjectClass 类型的参数，表示我要代理的就是这个真实对象
         */
        subjectInterface.hello("YuanLong");
    }
}
