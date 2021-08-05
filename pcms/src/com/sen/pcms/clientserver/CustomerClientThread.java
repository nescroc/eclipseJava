package com.sen.pcms.clientserver;

import java.io.ObjectInputStream;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.customer.fxml.CustomerController;
import com.sen.pcms.service.CustomerServerService;

public class CustomerClientThread extends Thread {
	CustomerController cc;
	CustomerServerService css;
	private ObjectInputStream ois;

	// ��ü �����ÿ� ������ ������ �޼����� ���� �� �ִ�
	// BufferedReader�� ���޹޴´�.
	public CustomerClientThread(ObjectInputStream ois,CustomerController cc) {
		this.ois = ois;
		this.cc = cc;
	}

	public void run() {
		try {
			System.out.println(this.getName());
			cc.setThread(this);
			while (true) {
				// ������ ������ �޼��� �б�
				CustomerVO cv = (CustomerVO) ois.readObject();
				css.serviceAnalysis(cv, this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
