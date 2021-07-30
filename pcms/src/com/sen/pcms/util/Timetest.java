package com.sen.pcms.util;

public class Timetest implements Runnable {

	public int[] timeSpent;
	public int timeSec;
	private boolean cstatus=false;
	public Timetest(int sec) {
		this.timeSec = sec;
	}

	@Override
	public void  run() {
		timeSec = 100000;
		for (int i = 0; i < timeSec; i++) {
			try {
				Thread.sleep(1000);
				while (cstatus) {}
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
