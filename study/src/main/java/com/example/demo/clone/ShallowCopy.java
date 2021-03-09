package com.example.demo.clone;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * 浅拷贝
         */
        Apple a1 = new Apple();
        a1.setPrice(10);
        Fruit f1 = new Fruit();
        f1.setColor("red");
        f1.setApple(a1);
        Fruit f2 = (Fruit) f1.clone();
        // 修改Apple对象
        a1.setPrice(20);
        System.out.println("f1:" + f1.getApple().getPrice());
        System.out.println("f2:" + f2.getApple().getPrice());
    }
}
