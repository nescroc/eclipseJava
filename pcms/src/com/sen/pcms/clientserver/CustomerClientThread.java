package com.sen.pcms.clientserver;

import java.io.ObjectInputStream;

import com.sen.pcms.VO.CustomerVO;

public class CustomerClientThread extends Thread {
	
	private ObjectInputStream ois;
	//��ü �����ÿ� ������ ������ �޼����� ���� �� �ִ�
	//BufferedReader�� ���޹޴´�.
	public CustomerClientThread(ObjectInputStream ois) {
		this.ois = ois;
	}
	public void run() {
			try {
				while (true) {
					//������ ������ �޼��� �б�
			CustomerVO cvo = (CustomerVO) ois.readObject();			
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
