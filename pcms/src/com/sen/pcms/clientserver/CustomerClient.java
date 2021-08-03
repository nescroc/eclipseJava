package com.sen.pcms.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CustomerClient implements Runnable {
	// ������ ����� Socket
	private Socket socket;
	// ������ ���� �޼����� �о���� ��Ʈ��
	private ObjectInputStream ois;
	// ������ �޽����� ���� �� ��Ʈ��
	private ObjectOutputStream oos;
	// Ű���� �Է³����� �о���� ��Ʈ��
	private CustomerClientThread cct;

	public CustomerClient() {
		
	}	
	public CustomerClientThread getclientThread() {		
		return cct;			
	}
	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 5000);
			System.out.println("Server Connect Success");
			// ��Ʈ�� ����			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			// ������ ������ �޼����� �о���� �б� ���� Thread�� ����
			// MutliClientThread �����ÿ�
			// ������ ������ �޼����� �о���� �� �ִ� ��Ʈ���� ����.
			CustomerClientThread t = new CustomerClientThread(ois);
			t.start();
			//�о�ͼ� ������ �����ϱ�
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	public ObjectOutputStream getOos() {
		return this.oos;
	}
}
