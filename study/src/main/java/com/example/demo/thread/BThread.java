package com.example.demo.thread;

public class BThread  extends  Thread{
        @Override
        public void run() {
            System.out.println("我是B线程,接下来我要睡10s");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是B线程,我执行完啦");
        }

}
