package com.sen.unicast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class UnicastServerThread extends Thread {
	//서버로부터 전달된 Socket(클라이언트와 연결된)을 저장
	Socket socket = null;
	BufferedReader br= null;
	BufferedWriter bw = null;
	//객체 생성시 Socket 을 전달받아서 멤버변수에 저장하는 생성자
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	//run()의 재정의
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//client와 송수신
			while (true) {
				//client 가 전달한 메세지 수신하기
				String msg = br.readLine();
				System.out.println(msg);
				//client 로 메시지 재전송
				bw.write(msg+"\n");
				bw.flush();
			}			
		} catch (IOException e) {
			//클라이언트와 연결이 끊어진 경우 발생
			InetAddress ip = socket.getInetAddress();
			String address = ip.getHostAddress();
			System.out.println("["+address+"]"+
						"와의 연결이 끊어졌습니다.");
		}
	}
}
