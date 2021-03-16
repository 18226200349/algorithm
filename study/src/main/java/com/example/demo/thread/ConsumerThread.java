package com.example.demo.thread;

public class ConsumerThread extends Thread {
    private Basket basket;

    public ConsumerThread(Basket basket) {
        this.basket = basket;
    }

    // 消费
    public void run() {
        basket.getEgg(basket);
    }
}
