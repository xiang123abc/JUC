package com.mashibing.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);// 指定 大小10

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}
		
		//strs.put("aaa"); //满了就会等待，程序阻塞
		strs.add("aaa"); // 满了会抛异常
		//strs.offer("aaa");
		boolean ifOffer = strs.offer("aaa", 1, TimeUnit.SECONDS);
		System.out.println("offer :"+ifOffer);

		System.out.println(strs);
		System.out.println(strs.size());

	}
}
