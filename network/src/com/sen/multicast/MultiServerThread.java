package com.sen.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServerThread extends Thread {
	
	//MultiServer가 전달해 주는 Socket을 담아둘 멤버변수
	private Socket socket;
	//client가 전달한 메세지를 읽어들일 Stream
	private BufferedReader in;
	//client로 메세지를 송신할 Stream
	private PrintWriter out;
	//모든 MultiServerThread객체를 저장하고 있는 ArrayList
	private ArrayList<MultiServerThread> clientList;
	//MultiServerThread는 객체가 생성되는 시점에 MultiServer로 부터
	//clientList와 client를 통신 할 수 있는 Socket을 전달받는다.
	public MultiServerThread(
			ArrayList<MultiServerThread> clientList,Socket socket) {
			this.socket = socket;
			this.clientList = clientList;
	}
	//스레드를 이용해서 실행시키고자하는 내용을 구현.
	public synchronized void run() {
		try {
			//스트림 연결
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			//클라이언트와 메세지 송수신을 반복
			while (true) {
				//클라이언트가 송신한 메세지 읽기
				 String msg = in.readLine();
				 System.out.println(msg);
		//모든 클라이언트에게 메세지 전달, broadcasting -> 밑에 확인
				 broadcasting(msg);
			}
			
		} catch (IOException e) {
			//client 와 연결이 끊어진 경우.
			//해당 MultiServerThread객체를 목록에서 삭제
			//3사람이 접속했는데 한사람이 접속을 끊어버린 경우
			//IOException 발생 이 경우 자기 자신을 없애줘야 한다.
			clientList.remove(this);
			//클라이언트와의 연결이 끊어져도 소켓은 그
			//ipAddress의 주소를 가지고 있다.
			String ipAddress = 
					socket.getInetAddress().getHostAddress();
			try {
				//다른 client들에게 퇴장사실을 알린다.
				broadcasting(ipAddress+"와 연결이 끊어졌습니다.");
			} catch (IOException e2) {}
		}
	}
	//모든 클라이언트에 메세지 전달
	public void broadcasting(String msg) throws IOException{
		//clientList에 저장된 MultiServerThread의 갯수만큼 반복하면서
		//각각의 MultiServerThread의 sendMsg메소드를 호출해서
		//연결된 Client에 메세지 전달.
		for (MultiServerThread t : clientList) {
			//개별 MultiServerThread의 senMsg를 호출해서
			//메세지를 각각의 client에 전달.
			t.sendMsg(msg);
		}
	}
	public void sendMsg(String msg) {
		out.println(msg);
		out.flush();		
	}
}
