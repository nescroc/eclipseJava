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
	//MultiServer�� ������ �ִ� Socket�� ��Ƶ� �������
	private Socket socket;
	//client�� ������ �޼����� �о���� Stream
	public ObjectInputStream ois;
	//client�� �޼����� �۽��� Stream
	public ObjectOutputStream oos;
	//��� MultiServerThread��ü�� �����ϰ� �ִ� ArrayList
	public HashMap<Integer,PcmsServerThread> clientList;
	
	//MultiServerThread�� ��ü�� �����Ǵ� ������ MultiServer�� ����
	//clientList�� client�� ��� �� �� �ִ� Socket�� ���޹޴´�.
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
	//�����带 �̿��ؼ� �����Ű�����ϴ� ������ ����.
	public synchronized void run() {
		try {
			//��Ʈ�� ����
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//Ŭ���̾�Ʈ�� �޼��� �ۼ����� �ݺ�
			while (!serverThreadRun) {
				//Ŭ���̾�Ʈ�� �۽��� �޼��� �б�
				 CustomerVO cv = (CustomerVO)ois.readObject();
				pssi.serviceAnalysis(cv,this);				 
				 //System.out.println(msg);
		//��� Ŭ���̾�Ʈ���� �޼��� ����, broadcasting -> �ؿ� Ȯ��
				 //broadcasting(msg);
			}
			
			
		} catch (IOException e) {
			//client �� ������ ������ ���.
			//�ش� MultiServerThread��ü�� ��Ͽ��� ����
			//3����� �����ߴµ� �ѻ���� ������ ������� ���
			//IOException �߻� �� ��� �ڱ� �ڽ��� ������� �Ѵ�.
			clientList.remove(this);
			//Ŭ���̾�Ʈ���� ������ �������� ������ ��
			//ipAddress�� �ּҸ� ������ �ִ�.		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		try {if (oos!=null) {oos.close();}} catch (Exception e2) {}
		try {if (ois!=null) {ois.close();}} catch (Exception e2) {}
		}
	}
	//��� Ŭ���̾�Ʈ�� �޼��� ����
	
	
	//true�� �ָ� ����
	public void threadClose(boolean threadServerRun) {
			this.serverThreadRun = threadServerRun;
	}
	
		
	
}
