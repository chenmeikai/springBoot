/**   
 * Copyright © 2018 
 * @Package: ThreadTest.java 
 * @author: Administrator   
 * @date: 2018年3月20日 下午10:59:16 
 */
package com.example.demo.Tread;

import java.util.concurrent.atomic.AtomicLong;

/**      
 * @Description:使用AtomicLong类型的变量来统计已处理请求的数量  
 * @author: cmk 
 * @date:   2018年3月20日 下午10:59:16     
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		
		AtomicLong num =new AtomicLong(0);
		
		
		Test1 test1 =new Test1(num);
		Test2 test2 =new Test2(num);
		
		new Thread(test1).start();
		new Thread(test2).start();
		
	}

}


class Test1 implements Runnable{
	AtomicLong num;

	/**
	 * @param num
	 */
	public Test1(AtomicLong num) {
		super();
		this.num = num;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println("test1:"+num.get());
			num.incrementAndGet();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class Test2 implements Runnable{
	
	AtomicLong num;
	
	/**
	 * @param num
	 */
	public Test2(AtomicLong num) {
		super();
		this.num = num;
	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println("test2:"+num.get());
			num.incrementAndGet();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}