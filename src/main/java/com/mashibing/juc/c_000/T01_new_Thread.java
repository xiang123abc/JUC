package com.mashibing.juc.c_000;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class T01_new_Thread {
    public static void main(String[] args) {

//ͨ��ʵ��Runnable�ӿ�������Thread�̣߳�
//ͨ��ʵ��Callable�ӿ�������Thread�߳�
//ͨ���̳�Thread��������һ���̣߳�

        Thread thread = new Thread(() -> {
            System.out.println("��ǰ�̶߳��������:"+Thread.currentThread().getName());
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��ǰ�̶߳��������:"+Thread.currentThread().getName());
            }
        });
        thread2.start();

        Runnable task =   ()->{
            System.out.println("��ǰ�̶߳��������:"+Thread.currentThread().getName());
        };
        Thread t = new Thread(task);
        t.start();


        FutureTask<Integer> task2 =  new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for(;i < 3;i++) {
                System.out.println(Thread.currentThread().getName() +
                        "  ���߳�ִ�����ڵ�ѭ������i��ֵΪ��" + i);
            }
            //call()�����ķ���ֵ
            return i;
        });
        new Thread(task2,"�з���ֵ���߳�").start();

    }

}
