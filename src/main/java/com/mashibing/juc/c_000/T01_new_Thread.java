package com.mashibing.juc.c_000;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class T01_new_Thread {
    public static void main(String[] args) {

//通过实现Runnable接口来创建Thread线程：
//通过实现Callable接口来创建Thread线程
//通过继承Thread类来创建一个线程：

        Thread thread = new Thread(() -> {
            System.out.println("当前线程对象的名称:"+Thread.currentThread().getName());
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程对象的名称:"+Thread.currentThread().getName());
            }
        });
        thread2.start();

        Runnable task =   ()->{
            System.out.println("当前线程对象的名称:"+Thread.currentThread().getName());
        };
        Thread t = new Thread(task);
        t.start();


        FutureTask<Integer> task2 =  new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for(;i < 3;i++) {
                System.out.println(Thread.currentThread().getName() +
                        "  的线程执行体内的循环变量i的值为：" + i);
            }
            //call()方法的返回值
            return i;
        });
        new Thread(task2,"有返回值的线程").start();

    }

}
