package com.mashibing.juc.c_000;

import com.mashibing.util.SleepUtil;

public class T05_Wait {
    static Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(t.getState());//RUNNABLE 2.就绪状态

//            synchronized(obj){
//                System.out.println(Thread.currentThread().getName()+"开始了");
//                try {
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            while (true){
                synchronized(obj){
                    System.out.println("t synchronized begin");
                    try {
                        SleepUtil.sleep(1000);
//                         obj.wait();//我等待， 别人会被唤醒？
//                        System.out.println("我被唤醒了！");
//                        obj.notify();
                        obj.notify();//notify()方法前，必须获得obj锁，也就是必须写在synchronized(obj) 代码段内。
                        obj.wait(); //让出锁
                        System.out.println("t get obj  after wait ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    SleepUtil.sleep(1000);
                    System.out.println("t3 synchronized begin");
                    try {
                        obj.notify();//notify()方法前，必须获得obj锁，也就是必须写在synchronized(obj) 代码段内。

                        obj.wait(); //让出锁
                        System.out.println("t3 get obj  after wait ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   // t.notify();
                }
            }
        }
    });


    static final   Object obj =  new Object();
    static class MyThread {

    }

    public static void main(String[] args) {



        System.out.println(t.getState());//NEW 1.新建

        t.start();////TERMINATED
        t3.start();
        System.out.println("code after t");
        System.out.println(t.getState());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());//TERMINATED  5.死亡/结束
        System.out.println("code after t :2");

    }
}
