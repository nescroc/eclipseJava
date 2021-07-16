package com.sen.thread;

public class SingleThreadEx extends Thread {
	private int[] temp;
	public SingleThreadEx(String threadname) {
		super(threadname);
		temp =  new int [10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
		
	}
	@Override
	public void run() {
		for (int start : temp) {
			try {
				sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s,",currentThread().getName());
			System.out.printf("temp Value : %d %n",start);
			
		}	
	}
	public static void main(String[] args) {
		new SingleThreadEx("첫번째").start();
	}
}
