package com.sen.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketEx {
	public static void main(String[] args) {
		// �����ڸ� �޾Ƶ��̱� ���� ServerSocket�� �ʿ��ϴ�.
		try {
			ServerSocket ss = new ServerSocket(3000);
			while (true) {
				Socket s = ss.accept();// �����ڰ� �߻��� ������ ����Ѵ�.
				InetAddress iaddr = s.getInetAddress();
				String u_ip = iaddr.getHostAddress();
				System.out.println(u_ip);
			} // end while

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
