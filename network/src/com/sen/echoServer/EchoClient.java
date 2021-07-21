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
			// 1. ������ ����� ���� ����
			// ������ ������ ip�� port��ȣ�� �����Ѵ�.
			// ������ �����ϴ� ���� �ش� ip�� port��ȣ�� ������ ��û�Ѵ�.
			socket = new Socket("localhost", 3000);
			// 2. �������κ��� inputStream�� outputStream ���
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			BufferedWriter bw = 
					new BufferedWriter(new OutputStreamWriter(os));
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(is));
			// 3. ������ �޼��� �����ϱ�
			bw.write("�ݰ����ϴ�. Ŭ���̾�Ʈ �Դϴ�.\n");
			bw.flush();
			// 4. ������ ���� �޼��� �б�
			String message = br.readLine();
			System.out.println("[������ ���� �޼���]" + message);
		} catch (UnknownHostException e) {
			// ip�� �ش��ϴ� ������ ã�� �� ���� ���
			e.printStackTrace();
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			// �ش� port��ȣ�� � ���񽺵� �������� �ʴ� ���
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		new EchoClient();
	}

}
