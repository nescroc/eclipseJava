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
			//1. �������� ����
				serverSocket = new ServerSocket(3000);
				System.out.println("���� �⵿��");
			//2.Ŭ���̾�Ʈ�� ������ ��ٸ�(û����.)
			//���������� Ŭ���̾�Ʈ�� �����û�� �����Ǹ�
			//�ش� Ŭ���̾�Ʈ�� ���ϰ� �ۼ����� �� �ִ� ������ �����س���.
			//�׸���, �ش� ������ �̿��ؼ� ���ӵ� Ŭ���̾�Ʈ��
			//ip������ ���ϰ� �ִ� InetAddress��ü�� ���� ���� �ִ�.
			//accept() �޼ҵ�� Ŭ���̾�Ʈ�� �����û�� ����������
			//����Ѵ�.---->block method��
				Socket socket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ�� ������ ���ϻ�����..");
			//������ Ŭ���̾�Ʈ�� ���� ���
				InetAddress clientIp = socket.getInetAddress();
				String ip = clientIp.getHostAddress();
				System.out.println("["+ip+"] �� ���ӵ�");
			//3. �������κ���  inputStream�� outputStream ���
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				BufferedReader br = 
						new BufferedReader(new InputStreamReader(is));
				BufferedWriter bw =
						new BufferedWriter(new OutputStreamWriter(os));
				
			//4. client�� ������ �޽��� �б�
				String message = br.readLine();
				System.out.println("�޼���"+message);
			//5. client�� �޼��� �����ϱ�
				bw.write("["+ip+"] �� ȯ���մϴ�.\n");
				bw.flush();				
		} catch (IOException e) {
			
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}
}
