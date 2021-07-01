package com.mashibing.juc.c_020;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger_my {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                String a = exchanger.exchange("a");
                System.out.println(a+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();



        new Thread(()->{
            try {
                String b = exchanger.exchange("b");
                System.out.println(b+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();


    }
}
