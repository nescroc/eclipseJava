package com.sen.unicast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	public UnicastServer() {
		ServerSocket server = null;
		try {
			// �������� ����
			server = new ServerSocket(5000);
		} catch (IOException e) {
			System.out.println("�ش� ��Ʈ�� ������Դϴ�.");
			System.exit(0);
		}
		try {
			while (true) {
				System.out.println("Server Ready...");
				// Ŭ���̾�Ʈ�� �����û�� �����Ǹ�
				// �ش� Ŭ���̾�Ʈ�� ����� Socket�� ����
				Socket socket = server.accept();
				// Ŭ���̾�Ʈ�� �޼����� �ۼ����� UnucastServerThread ����
				// UnicastServerThread ������ Socket �� ������
				UnicastServerThread thread = 
						new UnicastServerThread(socket);
				// UnicastServerThread�� start()�� ȣ����
				thread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new UnicastServer();
	}

}
