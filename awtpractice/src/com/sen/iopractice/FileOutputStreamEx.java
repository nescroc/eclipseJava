package com.sen.iopractice;

import java.io.FileOutputStream;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\Hello.txt");
			String message = "����ؿ� �������߰�";
			fos.write(message.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fos!=null) fos.close();
			} catch (Exception e2) {
					e2.printStackTrace();
			}
		}
	}
}
