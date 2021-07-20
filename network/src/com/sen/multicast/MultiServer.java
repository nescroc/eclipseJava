package com.sen.multicast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
	//Ư�� Ŭ���̾�Ʈ�� ���� �޼����� ��� Ŭ���̾�Ʈ����
	//�����ϱ� ���� Ŭ���̾�Ʈ�� �޼��� �ۼ��� �� �� �ִ� ����� ���� 
	//MultiServerThread��ü�� ���� �� �ڷᱸ���� ����.
	private ArrayList<MultiServerThread> clientList =
				new ArrayList<MultiServerThread>();
	private ServerSocket server = null;
	public MultiServer() {
			try {
				//5000�� ��Ʈ��ȣ���� Ŭ���̾�Ʈ�� ���ӿ�û��
				//��ٸ��� �ִ� �������� ����
				server = new ServerSocket(5000);
				System.out.println("�������۵�...");
				while (true) {
					//Ŭ���̾�Ʈ�� �����û�� ����ϰ� �ִٰ�
					//�����û�� �����Ǹ� �ش� Ŭ���̾�Ʈ�� ��� �� ���ִ�
					//������ ���� ��ȯ�Ѵ�.
					Socket socket = server.accept();
					//�������κ��� ip�ּҿ� ȣ��Ʈ���� ������ �ִ�
					//InetAddress ��ü ���.
					InetAddress ip = socket.getInetAddress();
					//InetAddress��ü�� ���� ip�ּ� ���
					String ipAddress = ip.getHostAddress();
					System.out.println(ipAddress+"����..");
					//client�� �ۼ��� �� �� �ִ� ����� ����
					//MultiServerThread�� �����ϰ� �ִ� Client��ü�� �����Ѵ�.
					MultiServerThread t =
							new MultiServerThread(clientList,socket);
					//������ ������.
					t.start();
					//������  MultiSErverThread ��ü�� clientList�� ����
					clientList.add(t);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
	}
	public static void main(String[] args) {
		new MultiServer();
	}
}
