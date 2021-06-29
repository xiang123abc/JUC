/**
 * 解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 * @author mashibing
 */
package com.mashibing.juc.c_018_00_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class T01_AtomicInteger {
	/*volatile*/ //int count1 = 0;
	
	AtomicInteger count = new AtomicInteger(0); 

	/*synchronized*/ void m() { 
		for (int i = 0; i < 10000; i++)
			//if count1.get() < 1000
			count.incrementAndGet(); //count1++
	}

	public static void main(String[] args) {
		T01_AtomicInteger t = new T01_AtomicInteger();

		List<Thread> threads = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m, "thread-" + i));
		}

		threads.forEach((o) -> o.start());

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//等所有线程结束
		threads.forEach((o) -> {
			try {
				o.join();//如果已经死了return ||  等我死掉（运行完）再走下一行
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(t.count);

	}

}
