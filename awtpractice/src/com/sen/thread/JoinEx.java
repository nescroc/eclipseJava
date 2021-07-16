package com.sen.thread;

class MyRunnableTwo implements Runnable{

	@Override
	public void run() {
		System.out.println("run");
		first();
	}

	public void first() {
		System.out.println("first");
		second();
	}

	public void second() {
		System.out.println("second");
	}
	
}

public class JoinEx {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" start");
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();
		try {
			myThread.join();//주석 처리하니까 안 기다림
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
	}
	
}
