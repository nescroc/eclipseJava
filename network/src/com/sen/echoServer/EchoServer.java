package com.sen.echoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket serverSocket =null;
	public EchoServer() {
		try {
			//1. 서버소켓 생성
				serverSocket = new ServerSocket(3000);
				System.out.println("서버 기동됨");
			//2.클라이언트의 접속을 기다림(청취함.)
			//서버소켓은 클라이언트의 연결요청이 접수되면
			//해당 클라이언트의 소켓과 송수신할 수 있는 소켓을 생성해낸다.
			//그리고, 해당 소켓을 이용해서 접속된 클라이언트의
			//ip정보를 지니고 있는 InetAddress객체를 얻을 수도 있다.
			//accept() 메소드는 클라이언트의 연결요청이 있을때까지
			//대기한다.---->block method임
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트와 연결할 소켓생성됨..");
			//접속한 클라이언트의 정보 얻기
				InetAddress clientIp = socket.getInetAddress();
				String ip = clientIp.getHostAddress();
				System.out.println("["+ip+"] 가 접속됨");
			//3. 소켓으로부터  inputStream과 outputStream 얻기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				BufferedReader br = 
						new BufferedReader(new InputStreamReader(is));
				BufferedWriter bw =
						new BufferedWriter(new OutputStreamWriter(os));
				
			//4. client가 전송한 메시지 읽기
				String message = br.readLine();
				System.out.println("메세지"+message);
			//5. client로 메세지 전송하기
				bw.write("["+ip+"] 님 환영합니다.\n");
				bw.flush();				
		} catch (IOException e) {
			
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
