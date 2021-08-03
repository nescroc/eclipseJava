package com.sen.pcms.clientserver;

import java.io.ObjectInputStream;

import com.sen.pcms.VO.CustomerVO;

public class CustomerClientThread extends Thread {
	
	private ObjectInputStream ois;
	//객체 생성시에 서버가 전달한 메세지를 읽을 수 있는
	//BufferedReader를 전달받는다.
	public CustomerClientThread(ObjectInputStream ois) {
		this.ois = ois;
	}
	public void run() {
			try {
				while (true) {
					//서버가 전송한 메세지 읽기
			CustomerVO cvo = (CustomerVO) ois.readObject();			
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
