package com.mashibing.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {

		//�����㷨
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();//--------
		
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		strs.transfer("aaa");//---------- transfer �������ȴ��������õ����ݲŷ���,transfer������ SynchronousQueue�� put ��������
		
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
