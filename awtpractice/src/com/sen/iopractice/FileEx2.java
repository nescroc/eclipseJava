package com.sen.iopractice;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("C:\\Users\\nes05\\OneDrive\\"
				+"���� ȭ��\\����\\test");
		if (directory.exists()) {
			if (directory.isDirectory()) {
				// ���� ���͸��� ��� ���� ���丮�� �̸����
				String[] fileNameList = directory.list();
				for (String fileName : fileNameList) {
					File myfile = new File(directory, fileName);
					if (myfile.isDirectory()) {
						System.out.println("���� �̸� : " + myfile.getName());
					} else {
						System.out.println("���� �̸� : " + myfile.getName() 
						+ " ���� ũ�� : " + myfile.length() + " bytes");
					}
				}

			}
		}
	}
}
