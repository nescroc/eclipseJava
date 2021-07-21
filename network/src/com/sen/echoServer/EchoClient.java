package com.sen.echoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	Socket socket =null;
	public EchoClient() {
		try {
			// 1. 서버와 통신할 소켓 생성
			// 연결한 서버의 ip와 port번호를 지정한다.
			// 소켓을 생성하는 순간 해당 ip의 port번호로 연결을 요청한다.
			socket = new Socket("localhost", 3000);
			// 2. 소켓으로부터 inputStream과 outputStream 얻기
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			BufferedWriter bw = 
					new BufferedWriter(new OutputStreamWriter(os));
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(is));
			// 3. 서버에 메세지 전송하기
			bw.write("반갑습니다. 클라이언트 입니다.\n");
			bw.flush();
			// 4. 서버가 보낸 메세지 읽기
			String message = br.readLine();
			System.out.println("[서버가 보낸 메세지]" + message);
		} catch (UnknownHostException e) {
			// ip에 해당하는 서버를 찾을 수 없을 경우
			e.printStackTrace();
			System.out.println("서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			// 해당 port번호에 어떤 서비스도 존재하지 않는 경우
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		new EchoClient();
	}

}
