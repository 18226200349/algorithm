package com.example.demo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程循环打印0-100的自然数
 */
public class TwoThreadOrderPrint {
    static final int SUM = 100;
    static int curr = 0;
    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            while (curr <= SUM) {
                System.out.println(Thread.currentThread().getName() + ":" + curr);
                curr++;
                //唤醒线程t2
                LockSupport.unpark(t2);
                //阻塞自己
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            while (curr <= SUM) {
                // 一上来先阻塞自己
                LockSupport.park();
                // 被唤醒之后从这一行开始执行(醒来之后再判断一下是否满足条件)
                if (curr <= SUM) {
                    System.out.println(Thread.currentThread().getName() + ":" + curr);
                    curr++;
                    //唤醒t1
                    LockSupport.unpark(t1);
                    // 再次while循环的时候又把自己park了
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
