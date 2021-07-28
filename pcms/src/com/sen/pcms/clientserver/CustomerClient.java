package com.sen.pcms.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CustomerClient {
	// ������ ����� Socket
	private Socket socket;
	// ������ ���� �޼����� �о���� ��Ʈ��
	private BufferedReader in;
	// ������ �޽����� ���� �� ��Ʈ��
	private PrintWriter out;
	// Ű���� �Է³����� �о���� ��Ʈ��
	private BufferedReader keyboard;

	public CustomerClient() {
		try {
			socket = new Socket("localhost", 5000);
			System.out.println("Server Connect Success");
			// ��Ʈ�� ����
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// ������ ������ �޼����� �о���� �б� ���� Thread�� ����
			// MutliClientThread �����ÿ�
			// ������ ������ �޼����� �о���� �� �ִ� ��Ʈ���� ����.
			CustomerClientThread t = new CustomerClientThread(in);
			t.start();
			// Ű����� �Է��� ������ �о�ͼ� ������ �����ϱ�
			while (true) {
				String text = keyboard.readLine();
				out.println(text);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new CustomerClient();
	}

}
