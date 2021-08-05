package com.sen.pcms.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.sen.pcms.service.PcmsServerServiceImpl;

public class PcmsServer implements Runnable {
	// 특정 클라이언트가 보낸 메세지를 모든 클라이언트에게
	// 전달하기 위해 클라이언트와 메세지 송수신 할 수 있는 기능을 가진
	// MultiServerThread객체를 저장 할 자료구조를 선언.
	public HashMap<Integer, PcmsServerThread> clientList; 
	public ServerSocket server = null;
	private boolean serverRun = false;
	PcmsServerServiceImpl pssi;

	public PcmsServer() {}	
	public PcmsServer(PcmsServerServiceImpl pssi) {
		this.pssi = pssi;
	}

	@Override
	public void run() {
		
		try {
			// 5000번 포트번호에서 클라이언트의 접속요청을
			// 기다리고 있는 서버소켓 생성
			clientList = new HashMap<Integer, PcmsServerThread>();
			seatInit();
			pssi.setThreadMap(clientList);			
			server = new ServerSocket(5000);
			System.out.println("서버시작됨...");
			
			while (!serverRun) {
				// 클라이언트의 연결요청을 대기하고 있다가
				// 연결요청이 접수되면 해당 클라이언트랑 통신 할 수있는
				// 소켓을 만들어서 반환한다.
				Socket socket = server.accept();
				// 소켓으로부터 ip주소와 호스트명을 가지고 있는
				// InetAddress 객체 얻기.

				InetAddress ip = socket.getInetAddress();
				// InetAddress객체로 부터 ip주소 얻기
				String ipAddress = ip.getHostAddress();
				System.out.println(ipAddress + "들어옴..");
				// client랑 송수신 할 수 있는 기능을 가진
				// MultiServerThread를 저장하고 있는 Client객체를 생성한다.
				PcmsServerThread pst = 
						new PcmsServerThread(pssi, socket);
				// 스레드 시작함.
			pst.start();
				// 생성된 MultiSErverThread 객체를 clientList에 저장

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void seatInit(){
		for (int i = 1; i <= 12; i++)
			clientList.put(i, null);	
	}
	
}
