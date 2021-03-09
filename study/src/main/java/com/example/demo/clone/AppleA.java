package com.example.demo.clone;

import lombok.Data;

@Data
public class AppleA {
    private double price;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
