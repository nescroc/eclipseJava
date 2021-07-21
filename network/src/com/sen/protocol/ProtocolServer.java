package com.sen.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
  100:���̵� => ���� 
  200:���̵� => ���� 
  300:���̵�:�޽��� => ��ȭ�濡 ������ ��� ����鿡�� �޼��� ����
  400:���̵�:���̵�2:�޼��� => ���̵�1�� ���̵�2���� �ӼӸ�
 */
public class ProtocolServer {
	ServerSocket ss = null;
	Socket s = null;
	BufferedReader br = null;
	BufferedWriter bw = null;

	public ProtocolServer() throws IOException {
		ss = new ServerSocket(5000);
		s = ss.accept();
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		while (true) {
			// Ŭ���̾�Ʈ�� ������ ���ڿ� �б�
			String text = br.readLine();
			// �о���� ���ڿ��� �����ڸ� �������� �и��ϱ�
			String[] words = text.split(":");
			if (words[0].equals(Protocol.ENTER))
				enter(words);
			else if (words[0].equals(Protocol.EXIT))
				exit(words);
			else if (words[0].equals(Protocol.SEND_MESSAGE))
				sendMessage(words);
			else if (words[0].equals(Protocol.SECRET_MESSAGE))
				sendSecretMessage(words);
			else
				bw.write("�߸��� ��û�Դϴ�.");
			bw.flush();
		}
	}

	public void enter(String[] arr) throws IOException{
			//100:���̵�
		System.out.println(arr[1]+"���� �����ϼ̽��ϴ�.");
		bw.write(arr[1]+"���� �����Ͽ����ϴ�.\n");
		bw.flush();
	}
	
	public void exit(String[] arr) throws IOException{
			//200:���̵�
		System.out.println(arr[1]+"���� �����ϼ̽��ϴ�.");
		bw.write(arr[1]+"���� �����Ͽ����ϴ�.\n");
		bw.flush();
	}

	public void sendMessage(String[] arr) throws IOException{
		//300:���̵�:�޼���
		System.out.println("["+arr[1]+"]"+arr[2]);
		bw.write("["+arr[1]+"]"+arr[2]);
		bw.flush();
	}

	public void sendSecretMessage(String[] arr) throws IOException{
		System.out.println("<"+arr[1]+">"+arr[3]);
		bw.write("<"+arr[1]+">"+arr[3]);
		bw.flush();
	}
	public static void main(String[] args) {
		try {
			new ProtocolServer();	
		} catch (IOException e) {}
	}



}
