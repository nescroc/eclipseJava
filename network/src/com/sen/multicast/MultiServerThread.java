package com.sen.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServerThread extends Thread {
	
	//MultiServer�� ������ �ִ� Socket�� ��Ƶ� �������
	private Socket socket;
	//client�� ������ �޼����� �о���� Stream
	private BufferedReader in;
	//client�� �޼����� �۽��� Stream
	private PrintWriter out;
	//��� MultiServerThread��ü�� �����ϰ� �ִ� ArrayList
	private ArrayList<MultiServerThread> clientList;
	//MultiServerThread�� ��ü�� �����Ǵ� ������ MultiServer�� ����
	//clientList�� client�� ��� �� �� �ִ� Socket�� ���޹޴´�.
	public MultiServerThread(
			ArrayList<MultiServerThread> clientList,Socket socket) {
			this.socket = socket;
			this.clientList = clientList;
	}
	//�����带 �̿��ؼ� �����Ű�����ϴ� ������ ����.
	public synchronized void run() {
		try {
			//��Ʈ�� ����
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			//Ŭ���̾�Ʈ�� �޼��� �ۼ����� �ݺ�
			while (true) {
				//Ŭ���̾�Ʈ�� �۽��� �޼��� �б�
				 String msg = in.readLine();
				 System.out.println(msg);
		//��� Ŭ���̾�Ʈ���� �޼��� ����, broadcasting -> �ؿ� Ȯ��
				 broadcasting(msg);
			}
			
		} catch (IOException e) {
			//client �� ������ ������ ���.
			//�ش� MultiServerThread��ü�� ��Ͽ��� ����
			//3����� �����ߴµ� �ѻ���� ������ ������� ���
			//IOException �߻� �� ��� �ڱ� �ڽ��� ������� �Ѵ�.
			clientList.remove(this);
			//Ŭ���̾�Ʈ���� ������ �������� ������ ��
			//ipAddress�� �ּҸ� ������ �ִ�.
			String ipAddress = 
					socket.getInetAddress().getHostAddress();
			try {
				//�ٸ� client�鿡�� �������� �˸���.
				broadcasting(ipAddress+"�� ������ ���������ϴ�.");
			} catch (IOException e2) {}
		}
	}
	//��� Ŭ���̾�Ʈ�� �޼��� ����
	public void broadcasting(String msg) throws IOException{
		//clientList�� ����� MultiServerThread�� ������ŭ �ݺ��ϸ鼭
		//������ MultiServerThread�� sendMsg�޼ҵ带 ȣ���ؼ�
		//����� Client�� �޼��� ����.
		for (MultiServerThread t : clientList) {
			//���� MultiServerThread�� senMsg�� ȣ���ؼ�
			//�޼����� ������ client�� ����.
			t.sendMsg(msg);
		}
	}
	public void sendMsg(String msg) {
		out.println(msg);
		out.flush();		
	}
}
