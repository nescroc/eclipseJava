package com.sen.objectserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObjectClient {
	public ObjectClient() {
		try {
			Socket socket = new Socket("localhost",5000);
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			//����� id�� pwd�� ����� Member ��ü�� ����
			MyMember member = new MyMember();
			member.setId("na");
			member.setPwd("1111");
			//������ Object ��ü�� Server�� ����
			oos.writeObject(member);
			//������ ������ �޼��� ���޹ޱ�
			String message = (String)ois.readObject();
			System.out.println(message);
			socket.close();
		} catch (UnknownHostException e) {
				e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ObjectClient();
	}
}