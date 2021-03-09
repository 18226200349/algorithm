package com.example.demo.thread;

/**
 *
 */
public class AThread {
    public static void main(String[] args) throws InterruptedException {

        BThread bThread=new BThread();
        bThread.start();
        //join 方法通过wait实现
        //wait释放对象锁,sleep不释放锁，让出cpu,wait是object方法，sleep是Thread方法
        bThread.join();
        System.out.printf("我是A线程(主线程),如果我不等B,肯定是我先执行完");

    }

}
