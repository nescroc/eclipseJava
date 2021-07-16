package com.sen.thread;

class ThreadSub extends Thread{
	
		public void run() {
			for (char ch = 'A'; ch <= 'z'; ch++) {
				System.out.println(ch);
				try {
					sleep(150);
				} catch (Exception e) {}
			}
		}
}


public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadSub ts = new ThreadSub();
		ts.start();
		for (int i = 1; i < 60; i++) {
			System.out.println(i);
			try {
				Thread.sleep(150);
			} catch (Exception e) {}
		}
	}
	
}
