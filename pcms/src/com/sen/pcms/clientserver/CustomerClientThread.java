package com.sen.pcms.clientserver;

import java.io.ObjectInputStream;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.customer.fxml.CustomerController;
import com.sen.pcms.service.CustomerServerService;

public class CustomerClientThread extends Thread {
	CustomerController cc;
	CustomerServerService css;
	private ObjectInputStream ois;

	// 객체 생성시에 서버가 전달한 메세지를 읽을 수 있는
	// BufferedReader를 전달받는다.
	public CustomerClientThread(ObjectInputStream ois,CustomerController cc) {
		this.ois = ois;
		this.cc = cc;
	}

	public void run() {
		try {
			System.out.println(this.getName());
			cc.setThread(this);
			while (true) {
				// 서버가 전송한 메세지 읽기
				CustomerVO cv = (CustomerVO) ois.readObject();
				css.serviceAnalysis(cv, this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
