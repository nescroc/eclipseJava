package com.sen.pcms.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.sen.pcms.service.PcmsServerServiceImpl;

public class PcmsServer implements Runnable {
	// Ư�� Ŭ���̾�Ʈ�� ���� �޼����� ��� Ŭ���̾�Ʈ����
	// �����ϱ� ���� Ŭ���̾�Ʈ�� �޼��� �ۼ��� �� �� �ִ� ����� ����
	// MultiServerThread��ü�� ���� �� �ڷᱸ���� ����.
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
			// 5000�� ��Ʈ��ȣ���� Ŭ���̾�Ʈ�� ���ӿ�û��
			// ��ٸ��� �ִ� �������� ����
			clientList = new HashMap<Integer, PcmsServerThread>();
			seatInit();
			pssi.setThreadMap(clientList);			
			server = new ServerSocket(5000);
			System.out.println("�������۵�...");
			
			while (!serverRun) {
				// Ŭ���̾�Ʈ�� �����û�� ����ϰ� �ִٰ�
				// �����û�� �����Ǹ� �ش� Ŭ���̾�Ʈ�� ��� �� ���ִ�
				// ������ ���� ��ȯ�Ѵ�.
				Socket socket = server.accept();
				// �������κ��� ip�ּҿ� ȣ��Ʈ���� ������ �ִ�
				// InetAddress ��ü ���.

				InetAddress ip = socket.getInetAddress();
				// InetAddress��ü�� ���� ip�ּ� ���
				String ipAddress = ip.getHostAddress();
				System.out.println(ipAddress + "����..");
				// client�� �ۼ��� �� �� �ִ� ����� ����
				// MultiServerThread�� �����ϰ� �ִ� Client��ü�� �����Ѵ�.
				PcmsServerThread pst = 
						new PcmsServerThread(pssi, socket);
				// ������ ������.
			pst.start();
				// ������ MultiSErverThread ��ü�� clientList�� ����

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
