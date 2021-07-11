package com.mashibing.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {

		//无锁算法
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();//--------
		
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		strs.transfer("aaa");//---------- transfer 是阻塞等待消费者拿到数据才返回,transfer方法和 SynchronousQueue的 put 方法类似
		
		//strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


	}
}
