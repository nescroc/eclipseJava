package com.sen.iopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyEx1 {
	static public void main(String args[]) {
		System.out.println("���Ϻ��� ����");
		long start = System.currentTimeMillis();
		FileInputStream src = null;
		FileOutputStream dest = null;
		byte[] kb8 = new byte[8192];
		try {
			// ���� ������ �б� ���� FileInputStream ��ü ����
			src = new FileInputStream(new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\�������̵�1.pdf"));
			// ���纻 ������ �����ϱ� ���� FileOutputStream��ü ����
			dest = new FileOutputStream(new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\�������̵�3.pdf"));
			// FileInputStream�� read()�޼��带 ���ؼ� �о���� ����
			// readValue �� ����
			int readValue = 0;
			while ((readValue = src.read(kb8)) != -1) {
				dest.write(kb8,0,readValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dest != null)
					dest.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (src != null)
					src.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		long copyTime = end - start;
		System.out.println("�ɸ� �ð� : " + copyTime + "�и���");
	}
}
