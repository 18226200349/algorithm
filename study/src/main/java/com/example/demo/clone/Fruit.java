package com.example.demo.clone;

import com.example.demo.clone.Apple;
import lombok.Data;

@Data
public class Fruit implements  Cloneable{
    private String color;
    private Apple apple;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
