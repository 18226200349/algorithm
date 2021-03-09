package com.example.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    int state = 1;

    public void printA(){
        //锁住对象
        lock.lock();
        try {
            while (state!=1){
                c1.await();
            }
            System.out.print(" A");
            state = 2;
            //唤醒B
            c2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        //锁住对象
        lock.lock();
        try {
            while (state!=2){
                c2.await();
            }
            System.out.print("B");
            state = 3;
            //唤醒C
            c3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        //锁住对象
        lock.lock();
        try {
            while (state!=3){
                c3.await();
            }
            System.out.print("C");
            state=1;
            //唤醒A
            c1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABC p = new PrintABC();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                p.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                p.printB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                p.printC();
            }
        }).start();
    }
}
