package com.sen.iopractice;

import java.io.*;

public class DataInputStreamEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {			
			fis = new FileInputStream("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\data.sav");
			dis = new DataInputStream(fis);
			//DataInputStream�� �⺻�ڷ����� ������ä�� �����
			//���� �о���� �� �ִ� read�޼��尡 �����Ѵ�.
			//�о���� ���� �ݵ�� ����� ������� �о�;� �Ѵ�.
			int i = dis.readInt();
			double d = dis.readDouble();
			String s = dis.readUTF();
			System.out.println("i��"+i);
			System.out.println("d��"+d);
			System.out.println("s��"+s);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (dis!=null) {dis.close();}
			} catch (IOException e) {}
			try {
				if (fis!=null) {fis.close();}
			} catch (IOException e) {}

		}
		
	}
	
}
