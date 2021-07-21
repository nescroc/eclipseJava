package com.sen.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	Socket socket = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	BufferedReader keyboard = null;
	
	public ProtocolClient() {
		try {
			socket = new Socket("localhost",5000);			
		} catch (UnknownHostException e) {
			System.err.println("������ ã�� �� �����ϴ�.");
			System.exit(0);
		}catch (IOException e) {
				System.err.println("������ ������ �� �����ϴ�.");
				System.exit(0);
		}
		try {
			//Ű����� ����� ��Ʈ�� ���
			keyboard = new BufferedReader(
					new InputStreamReader(System.in));
			//socket ���κ��� Stream ���
			bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			//������ �޼��� �ְ� �ޱ�
			while (true) {
				//Ű���� �Է³��� �б�
				String msg = keyboard.readLine();

/**
  100:���̵� => ���� 
  200:���̵� => ���� 
  300:���̵�:�޽��� => ��ȭ�濡 ������ ��� ����鿡�� �޼��� ����
  400:���̵�:���̵�2:�޼��� => ���̵�1�� ���̵�2���� �ӼӸ�
 */
			//�޼��� ������ ����
				bw.write(msg+"\n");
				bw.flush();
				String[] words = msg.split(":");
				//������ ������ �޼��� ����
				String getMsg = br.readLine();
				System.out.println(getMsg);
				//200���� ��� �����ϱ�
				if (words[0].equals(Protocol.EXIT))
					throw new IOException();
			}
					
		} catch (IOException e) {
			System.out.println("�������� ������ ���������ϴ�.");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
