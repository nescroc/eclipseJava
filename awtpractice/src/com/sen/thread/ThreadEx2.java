package com.sen.thread;

class ThreadSub1 extends Thread {
	private String name;
	private String lastname;

	public ThreadSub1(String a, String b, int x) {
		name = a;
		lastname = b;
		setPriority(x);
		setDaemon(true);
	}

	public void run() {
		System.out.println(Thread.activeCount());
		int xx = Thread.activeCount();
		Thread[] th = new Thread[xx];
		Thread.enumerate(th);
		for (int i = 0; i < th.length; i++) {
			System.out.println(th[i].getName()+" : "+th[i].getPriority()
					+" : "+th[i].isDaemon()+" : "+th[i].isAlive());
		}
		while (true) {
			System.out.print("�̸�  : "+name);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("\t�̸�2 : "+lastname);
			}
		}
	}
}

public class ThreadEx2 {
	public static void main(String[] args) {
		ThreadSub1 ts = new ThreadSub1("�Ϛc", "��", 1);
		ts.start();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			ThreadSub1 ts1 = new ThreadSub1("�Ϝ�", "��", 5);
			ts1.start();
			try {
				Thread.sleep(300);//������ �������� �ʱ�����
			} catch (Exception e2) {}
		}
				
	}
	
}
