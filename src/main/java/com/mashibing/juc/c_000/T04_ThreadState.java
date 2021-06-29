package com.mashibing.juc.c_000;

import com.mashibing.util.SleepUtil;

public class T04_ThreadState {
    static final   Object obj =  new Object();

    static Thread t = new MyThread();

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            SleepUtil.sleep(500);
            System.out.println("t2 is runing   t1:"+t.getState());//t: WAITING

        }
    });

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t3 is run   t1:"+t.getState());//t: WAITING
            synchronized(obj){
                while (true){
                    SleepUtil.sleep(500);
                    System.out.println("t3 is   get obj,   t1:"+t.getState());
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());//RUNNABLE 2.就绪状态
            t2.start();

            try {
                //Thread.sleep(500);
                t2.join();//　
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            t3.start();
//            while (true){
//                synchronized(obj){
//                    try {
//                        System.out.println("t is  runing get obj,   t3:"+t3.getState());//do Thing
//                        obj.notify();
//                        obj.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
                synchronized(obj){
                    while (true){
                        try {
                            System.out.println("t is  runing has  obj,   t3:"+t3.getState());//do Thing
                            obj.notify();
                            obj.wait();//让出锁后还在while循环中
                            System.out.println(" t 得到锁了,从这开始继续往下执行 ");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

//
//            for (int i = 0; i < 1; i++) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(""+this.getState());
        }
    }

    public static void main(String[] args) {

        System.out.println(t.getState());//NEW 1.新建

        t.start();////TERMINATED
        System.out.println(t.getState());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());//TERMINATED  5.死亡/结束

    }
}
