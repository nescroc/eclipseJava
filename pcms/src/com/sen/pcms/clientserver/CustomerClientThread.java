package com.sen.pcms.clientserver;

import java.io.BufferedReader;
import java.io.IOException;

public class CustomerClientThread extends Thread {
	
	private BufferedReader in;
	//��ü �����ÿ� ������ ������ �޼����� ���� �� �ִ�
	//BufferedReader�� ���޹޴´�.
	public CustomerClientThread(BufferedReader in) {
		this.in = in;
	}
	public void run() {
			try {
				while (true) {
					//������ ������ �޼��� �б�
					String text = in.readLine();
					System.out.println("���Ÿ޽���  : "+text);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
