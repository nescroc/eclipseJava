package com.sen.pcms.util;

public class Timetest extends Thread {

	public int[] timeSpent;
	public int timeSec;
	private boolean cstatus=false;
	public Timetest(int sec) {
		this.timeSec = sec;
	}

	@Override
	public void run() {
		timeSec = 100000;
		for (int i = 0; i < timeSec; i++) {
			try {
				sleep(1000);
				System.out.println(i+"초지났습니다");
				if ((i % 60== 0)&&i!=0) {
					System.out.println("1분 지났습니다");
				}else  if ((i% 10==0)&&i!=0) {
				sleep(10000);
				}				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		new Timetest(36000).run();
		
	}

	public boolean isCstatus() {
		return cstatus;
	}

	public void setCstatus(boolean cstatus) {
		this.cstatus = cstatus;
	}
	
}
