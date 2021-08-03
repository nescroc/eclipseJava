package com.sen.pcms.util;

public class TimeManager implements Runnable {

	private int cno;
	private String cid;
	private int timeSec;
	private boolean cstatus = false;
	
	@Override
	public void run() {
		timeSec = 100000;
		for (int i = 0; i < timeSec; i++) {
			try {
				Thread.sleep(1000);
				while (cstatus) {
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public boolean isCstatus() {
		return cstatus;
	}
	
	public void setCstatus(boolean cstatus) {
		this.cstatus = cstatus;
	}
	public void timeSecAdd(int timeSec) {
		this.timeSec = this.timeSec+timeSec;
	}
}
