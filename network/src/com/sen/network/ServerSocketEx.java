package com.sen.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketEx {
	public static void main(String[] args) {
		// 접속자를 받아들이기 위해 ServerSocket이 필요하다.
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(3000);
			while (true) {
				Socket s = ss.accept();// 접속자가 발생할 때까지 대기한다.
				InetAddress iaddr = s.getInetAddress();
				String u_ip = iaddr.getHostAddress();
				System.out.println(u_ip);
			} // end while

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {if (ss != null)ss.close();
			} catch (Exception e2) {}

		}
	}

}
