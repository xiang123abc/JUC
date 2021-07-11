package com.mashibing.juc.c_025;

import com.mashibing.util.SleepUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //����Ϊ0
	public static void main(String[] args) throws InterruptedException {

		//�����������-������ģʽ,CASʵ���̵߳İ�ȫ����
		BlockingQueue<String> strs = new SynchronousQueue<>();//   put() ��ͱ������ˣ�ֻ��take�߳̽���������put�̲߳ſ��Է���,������Ϊ����һ���߳����̼߳�һ��һ������Ϣ��ģ�͡�
		
		new Thread(()->{
			try {
				//SleepUtil.sleep(3000);
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		//SleepUtil.sleep(3000);
		strs.put("aaa"); //�����ȴ�����������
		//strs.put("bbb");
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
