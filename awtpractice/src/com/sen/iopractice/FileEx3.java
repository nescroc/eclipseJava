package com.sen.iopractice;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args) throws IOException {
		// ���ϻ���
		File f1 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newFile.txt");
		if (f1.exists()) {
			System.out.println("�����̸� : " + f1.getName());
		} else {
			// IOException �߻�
			if (f1.createNewFile()) {
				System.out.println("���ο� ������ ��������ϴ�.");
			}
		}
		File f2 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newDirectory");
		if (!f2.exists())
			f2.mkdir();
		else 
			System.out.println("���͸� �̸� : "+f2.getPath());
		
		/*
		 * File f3 = new
		 * File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newFile.txt"); if
		 * (f3.exists()) f3.delete();
		 */		
		//���� Ȥ�� ���͸� �̸�����
		File src = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newFile.txt");
		File dest = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newDirectory");
		File dest2 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\newDirectory\\desc2.txt");
		if (src.exists()) {
			src.renameTo(dest);
			src.renameTo(dest2);
		}
		
		
		if (f2.isDirectory()) {//���͸��� ����� �����
			String dir[] = f2.list();
			System.err.println("\n\n Dir Content ====================\n");
			for (String dirs : dir) {
				System.out.println("dirs : "+dirs);
			}
			
		}
	}

}
