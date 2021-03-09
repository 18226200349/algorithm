package com.example.demo.clone;

import lombok.Data;

@Data
public class FruitA implements Cloneable {
    private String color;
    private AppleA apple;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 浅拷贝的写法
        // Object object = super.clone();
        // return object;

        // 深拷贝的实现
        FruitA fruit = (FruitA) super.clone();
        fruit.setApple((AppleA) fruit.getApple().clone());
        return fruit;
    }
}
