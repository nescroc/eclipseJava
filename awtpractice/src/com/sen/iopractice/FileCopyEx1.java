package com.sen.iopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("���Ϻ��� ����");
		long start = System.currentTimeMillis();
		
		FileInputStream src = null;
		FileOutputStream dest= null;
		try {
				//���� ������ �б� ���� FileInputStream ��ü ����
			src = new FileInputStream(new File("C:\\Users\\nes05\\"+
				"OneDrive\\���� ȭ��\\����\\�������̵�1.pdf"));
			//���纻 ������ �����ϱ� ���� FileOutputStream ��ü ����
			dest = new FileOutputStream(new File("C:\\Users\\nes05\\"+
					"OneDrive\\���� ȭ��\\����\\dest\\�������̵�1.pdf"));
			//FileInputStream�� ���ؼ� �о���� ���� ������ ����
			byte[] readValue = new byte[8000];
			//FileInputStream�� read()�޼��带 ���ؼ� �о���� ����
			//readValue�� ����
			while ((src.read(readValue))!=-1) {
				//readValue�� ����� ���� FileOutputStream�� write()
				//�޼��带 ���ؼ� ���Ͽ� ���
				dest.write(readValue);				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (dest!=null)dest.close(); 
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				if (src!=null)src.close(); 
			} catch (IOException e2) {
				e2.printStackTrace();
			}			
		}
		long end = System.currentTimeMillis();
		long copyTime = end - start;
		System.out.println("�ɸ� �ð�  : "+copyTime);
	}
}
