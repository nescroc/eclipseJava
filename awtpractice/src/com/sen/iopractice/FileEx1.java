package com.sen.iopractice;

import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\Hello.txt");
		System.out.println("�������� ���� : "+ file.isFile());
		System.out.println("���͸� ���� ���� : "+file.isDirectory()) ;
		System.out.println("����� : " +file.getPath());
		System.out.println("������ : " +file.getAbsolutePath());
		System.out.println("���͸� Ȥ�� ���� �̸�  : "+file.getName());
		System.out.println("������ ����  : "+file.length());
		System.out.println("������ ���� ���� ��¥ : "+file.lastModified());
	}

}
