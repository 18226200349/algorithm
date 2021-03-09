package com.example.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 循环输出ABC
 */
public class ThreadCountDownLatchDemo {
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);

    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱！");
                countDownLatch1.countDown();
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch1.await();
                    System.out.println("拿出一瓶牛奶！");
                    countDownLatch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch2.await();
                    System.out.println("关上冰箱！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //下面三行代码顺序可随意调整，程序运行结果不受影响
        thread3.start();
        thread1.start();
        thread2.start();
    }
}
