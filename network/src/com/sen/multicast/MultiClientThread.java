package com.sen.multicast;

import java.io.BufferedReader;
import java.io.IOException;

public class MultiClientThread extends Thread {
	
	private BufferedReader in;
	//��ü �����ÿ� ������ ������ �޼����� ���� �� �ִ�
	//BufferedReader�� ���޹޴´�.
	public MultiClientThread(BufferedReader in) {
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
