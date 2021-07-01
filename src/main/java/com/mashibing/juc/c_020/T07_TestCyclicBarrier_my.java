package com.mashibing.juc.c_020;

import com.mashibing.util.SleepUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier_my {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(20,()->{
            SleepUtil.sleep(500);
            System.out.println("ย๚มห");}
        );

        for (int i = 0; i < 100; i++) {
             new Thread(() -> {
                 try {
                     cb.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } catch (BrokenBarrierException e) {
                     e.printStackTrace();
                 }
             }).start();
        }
    }
}
