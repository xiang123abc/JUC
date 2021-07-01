package com.mashibing.juc.c_020;

import com.mashibing.util.SleepUtil;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch_my {
    public static void main(String[] args) {
      //  usingJoin();
     //  System.out.println("code after  usingJoin()");
        usingCountDownLatch();
    }

    private static void usingCountDownLatch() {
        System.out.println("usingCountDownLatch");
        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<1000; j++) result += j;
                SleepUtil.sleep(1000*2);
                //latch.countDown();//  最后一个countDown 后  latch.await(); 马上放开 countDown() 后一行代码可能就在   end latch 之后执行
                System.out.println(Thread.currentThread().getName());//
                latch.countDown();
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[10];

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                //SleepUtil.sleep(1000);
                int result = 0;
                for(int j=0; j<1000; j++) result += j;
                System.out.println(Thread.currentThread().getName());

            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

//        for (int i = 0; i < threads.length; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("end join");
    }
}
