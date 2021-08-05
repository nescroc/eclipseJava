package com.sen.pcms.clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sen.pcms.customer.fxml.CustomerController;

public class CustomerClient implements Runnable {
	// 서버랑 연결된 Socket
	private Socket socket;
	// 서버가 보낸 메세지를 읽어들일 스트림
	public ObjectInputStream ois;
	// 서버로 메시지를 전송 할 스트림
	public ObjectOutputStream oos;
	// 키보드 입력내용을 읽어들일 스트림
	CustomerController cc;
	

	public CustomerClient(CustomerController cc) {
		this.cc = cc;
	}	
	
	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 5000);
			System.out.println("Server Connect Success");
			// 스트림 연결			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			// 서버가 전송한 메세지를 읽어들일 읽기 전용 Thread를 생성
			// MutliClientThread 생성시에
			// 서버가 전송한 메세지를 읽어들일 수 있는 스트림을 전달.
			CustomerClientThread t = new CustomerClientThread(ois,cc);
			t.start();
			//읽어와서 서버로 전송하기
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
}
