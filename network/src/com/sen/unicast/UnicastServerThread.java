package com.sen.unicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UnicastServerThread extends Thread {
	//�����κ��� ���޵� Socket(Ŭ���̾�Ʈ�� �����)�� ����
	Socket socket = null;
	BufferedReader br= null;
	BufferedWriter bw = null;
	//��ü ������ Socket �� ���޹޾Ƽ� ��������� �����ϴ� ������
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	//run()�� ������
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//client�� �ۼ���
			while (true) {
				//client �� ������ �޼��� �����ϱ�
				String msg = br.readLine();
				System.out.println(msg);
				//client �� �޽��� ������
				bw.write(msg+"\n");
				bw.flush();
			}			
		} catch (IOException e) {
			//Ŭ���̾�Ʈ�� ������ ������ ��� �߻�
			InetAddress ip = socket.getInetAddress();
			String address = ip.getHostAddress();
			System.out.println("["+address+"]"+
						"���� ������ ���������ϴ�.");
		}
	}
}
