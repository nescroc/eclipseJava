package com.sen.objectserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
	public ObjectServer() {
		try {
			//�������� ����
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("���� �⵿��....");
			//Ŭ���̾�Ʈ�� �����û�� û���Ѵ�.
			//Ŭ���̾�Ʈ�� �����û�� �����Ǹ�
			//Ŭ���̾�Ʈ�� ����� Socket ����
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ ���� ������.....");
			System.out.println("[client]"+socket.getInetAddress());
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			//��ü�� �ۼ����ϱ� ����
			//ObjectInputStream�� ObjectOutputStream�� 
			//inputStream�� outputStream�� �����Ѵ�.
			ObjectInputStream ois =new ObjectInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);
		//readObject�� ObjectInputStream�� ���ؼ� ���޹���
		//����ȭ�� ��ü�� ������ȭ ����
		//(��ü�� ����, ���޹��� ����ȭ�� ��ü�� ������ ä���)
		//�� ���ؼ� client�� ������ ��ü�� �Ȱ��� ��ü�� ���� �����.
			MyMember member = (MyMember)ois.readObject();
			System.out.println("Ŭ���̾�Ʈ ���� ������.....");
			System.out.println("���̵�  : "+member.getId());
			System.out.println("��й�ȣ : "+member.getPwd());
			//Ŭ���̾�Ʈ�� �޼��� ����
			oos.writeObject("["+member.getId()+"]�� �α��� ����");
		} catch (IOException e) {
				e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
