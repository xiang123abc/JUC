package com.mashibing.juc.c_020;

import com.mashibing.juc.c_001.T;
import com.mashibing.util.SleepUtil;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T10_TestReadWriteLock_my {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }





    public static void main(String[] args) {
/*
        //  new Thread(T10_TestReadWriteLock_my::read(lock)).start();
        //  new Thread(()->{read(lock)}).start();
        new Thread(()->{T10_TestReadWriteLock_my.read(lock);}).start();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{T10_TestReadWriteLock_my.write(lock, finalI);}).start();
        }
        SleepUtil.sleep(13*1000);
        System.out.println("bottom");
 */

        Runnable r = ()->read(lock);
        Runnable w = ()->write(lock,4);

        for (int i = 0; i < 10; i++) new Thread(r).start();
        for (int i = 0; i < 2; i++) new Thread(w).start();
        SleepUtil.sleep(13*1000);
        System.out.println("bottom");
    }
}
