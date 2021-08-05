package com.sen.pcms.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sen.pcms.customer.fxml.CustomerController;

public class CustomerClient implements Runnable {
	// ������ ����� Socket
	private Socket socket;
	// ������ ���� �޼����� �о���� ��Ʈ��
	public ObjectInputStream ois;
	// ������ �޽����� ���� �� ��Ʈ��
	public ObjectOutputStream oos;
	// Ű���� �Է³����� �о���� ��Ʈ��
	CustomerController cc;
	

	public CustomerClient(CustomerController cc) {
		this.cc = cc;
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
			CustomerClientThread t = new CustomerClientThread(ois,cc);
			t.start();
			//�о�ͼ� ������ �����ϱ�
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
}
