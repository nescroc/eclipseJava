package com.sen.pcms.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.service.PcmsServerServiceImpl;

public class PcmsServerThread extends Thread {
	private PcmsServerServiceImpl pssi;
	CustomerVO cv;
	//MultiServer가 전달해 주는 Socket을 담아둘 멤버변수
	private Socket socket;
	//client가 전달한 메세지를 읽어들일 Stream
	public ObjectInputStream ois;
	//client로 메세지를 송신할 Stream
	public ObjectOutputStream oos;
	//모든 MultiServerThread객체를 저장하고 있는 ArrayList
	public HashMap<Integer,PcmsServerThread> clientList;
	
	//MultiServerThread는 객체가 생성되는 시점에 MultiServer로 부터
	//clientList와 client를 통신 할 수 있는 Socket을 전달받는다.
	private  boolean serverThreadRun = false;
	public PcmsServerThread(
			PcmsServerServiceImpl pssi,
			HashMap<Integer,PcmsServerThread> clientList,
						Socket socket) {
			this.socket = socket;
			this.clientList = clientList;
			this.pssi = pssi;
			cv = new CustomerVO();
	}
	//스레드를 이용해서 실행시키고자하는 내용을 구현.
	public synchronized void run() {
		try {
			//스트림 연결
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트와 메세지 송수신을 반복
			while (!serverThreadRun) {
				//클라이언트가 송신한 메세지 읽기
				 CustomerVO cv = (CustomerVO)ois.readObject();
				pssi.serviceAnalysis(cv,this);				 
				 //System.out.println(msg);
		//모든 클라이언트에게 메세지 전달, broadcasting -> 밑에 확인
				 //broadcasting(msg);
			}
			
			
		} catch (IOException e) {
			//client 와 연결이 끊어진 경우.
			//해당 MultiServerThread객체를 목록에서 삭제
			//3사람이 접속했는데 한사람이 접속을 끊어버린 경우
			//IOException 발생 이 경우 자기 자신을 없애줘야 한다.
			clientList.remove(this);
			//클라이언트와의 연결이 끊어져도 소켓은 그
			//ipAddress의 주소를 가지고 있다.		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		try {if (oos!=null) {oos.close();}} catch (Exception e2) {}
		try {if (ois!=null) {ois.close();}} catch (Exception e2) {}
		}
	}
	//모든 클라이언트에 메세지 전달
	
	
	//true를 주면 꺼짐
	public void threadClose(boolean threadServerRun) {
			this.serverThreadRun = threadServerRun;
	}
	
		
	
}
