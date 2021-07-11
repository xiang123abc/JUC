package com.mashibing.juc.c_025;

import com.mashibing.util.SleepUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {

		//经典的生产者-消费者模式,CAS实现线程的安全访问
		BlockingQueue<String> strs = new SynchronousQueue<>();//   put() 后就被阻塞了，只有take线程进行了消费put线程才可以返回,可以认为这是一种线程与线程间一对一传递消息的模型。
		
		new Thread(()->{
			try {
				//SleepUtil.sleep(3000);
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		//SleepUtil.sleep(3000);
		strs.put("aaa"); //阻塞等待消费者消费
		//strs.put("bbb");
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
