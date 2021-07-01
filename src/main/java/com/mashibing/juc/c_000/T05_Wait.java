package com.mashibing.juc.c_000;

import com.mashibing.util.SleepUtil;

public class T05_Wait {
    static Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(t.getState());//RUNNABLE 2.����״̬

//            synchronized(obj){
//                System.out.println(Thread.currentThread().getName()+"��ʼ��");
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
//                         obj.wait();//�ҵȴ��� ���˻ᱻ���ѣ�
//                        System.out.println("�ұ������ˣ�");
//                        obj.notify();
                        obj.notify();//notify()����ǰ��������obj����Ҳ���Ǳ���д��synchronized(obj) ������ڡ�
                        obj.wait(); //�ó���
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
                        obj.notify();//notify()����ǰ��������obj����Ҳ���Ǳ���д��synchronized(obj) ������ڡ�

                        obj.wait(); //�ó���
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



        System.out.println(t.getState());//NEW 1.�½�

        t.start();////TERMINATED
        t3.start();
        System.out.println("code after t");
        System.out.println(t.getState());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());//TERMINATED  5.����/����
        System.out.println("code after t :2");

    }
}
