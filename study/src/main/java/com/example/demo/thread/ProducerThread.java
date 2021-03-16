package com.example.demo.thread;

public class ProducerThread extends  Thread {
    private Basket basket;

    public ProducerThread(Basket basket) {
        super();
        this.basket = basket;
    }

    // 生产
    public void run() {
        basket.putEgg(basket);
    }
}
