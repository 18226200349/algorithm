package com.example.demo.clone;

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        /**
         * 深拷贝
         */
        AppleA a1 = new AppleA();
        a1.setPrice(10);
        FruitA f1 = new FruitA();
        f1.setColor("red");
        f1.setApple(a1);
        FruitA f2 = (FruitA) f1.clone();
        a1.setPrice(20);
        System.out.println("f1:" + f1.getApple().getPrice());
        System.out.println("f2:" + f2.getApple().getPrice());
    }
}
