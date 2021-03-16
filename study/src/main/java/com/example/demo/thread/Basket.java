package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者篮子
 */
public class Basket{

    /**
     * 共享资源-篮子(用来放鸡蛋)
     */
    private List<Egg> eggs = new ArrayList<Egg>();
    /**
     *
     * Title: 消费-从篮子里取鸡蛋<br>
     * Description: 消费-从篮子里取鸡蛋<br>
     * CreateDate: 2018年3月20日 下午2:02:23<br>
     *
     * @category getEgg
     * @author felix.yl
     * @return
     */
    public Egg getEgg(Basket basket) {

        synchronized (basket) {
            while (eggs.size() == 0) {
                try {
                    // 消费线程进入阻塞队列
                    basket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 取出鸡蛋,清空篮子
            Egg egg = eggs.get(0);
            eggs.clear();

            // 唤醒生产者线程生产鸡蛋
            notify();
            System.out.println("消费鸡蛋");
            return egg;
        }

    }

    /**
     *
     * Title: 生产-往篮子中放鸡蛋<br>
     * Description: 生产-往篮子中放鸡蛋<br>
     * CreateDate: 2018年3月20日 下午2:06:30<br>
     *
     * @category putEgg
     * @author felix.yl
     * @param basket
     */
    public void putEgg(Basket basket) {

        synchronized (basket) {
            while (eggs.size() > 0) {
                try {
                    // 生产线程进入阻塞队列
                    basket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产鸡蛋,放入篮子
            eggs.add(new Egg());

            // 唤醒消费者
            notify();
            System.out.println("生产鸡蛋");
        }

    }

    /**
     *
     * Title: 程序触发入口<br>
     * Description: 程序触发入口<br>
     * CreateDate: 2018年3月20日 下午2:17:41<br>
     *
     * @category 程序触发入口
     * @author felix.yl
     * @param args
     */
    public static void main(String[] args) {
        // 生产者&消费者共享同一资源
        Basket basket = new Basket();

        // 循环生产10个鸡蛋
        for (int i = 0; i < 10; i++) {
            // 启动生产者线程
            new ProducerThread(basket).start();
            // 启动消费者线程
            new ConsumerThread(basket).start();
        }
    }

}
