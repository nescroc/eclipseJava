package com.sen.iopractice;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args)  {
		//���ϻ���
		File f1 = new File
				("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
							+"����\\test\\newFile.txt");//�� ������ �������
		if (f1.exists()) {
			System.out.println("�����̸�"+f1.getName());
		}else {
			//IOException �߻�
			try {
				if (f1.createNewFile()) {					
					System.out.println("���ο� ������ ��������ϴ�.");
					}				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		//���͸� ����
		File f2 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
							+"����\\test\\newDirectory");
		if (!f2.exists()) {
			f2.mkdir();
		}else {
			System.out.println("���͸� �̸� : "+f2.getPath());
			System.out.println("���͸� �̸� : "+f2.getAbsolutePath());
		}
		
		//���� Ȥ�� ���͸� ����
//		File f3 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
//							+"����\\test\\newDirectory");
//		
//		if (f3.exists()) {
//			f3.delete()
//		}
		
		File src = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
					+"����\\test\\newDirectory\\newFile2.txt");
		File dest = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
					+"����\\test\\newDirectory\\dest.txt");
		File dest2 = new File("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\"
							+"����\\test\\newDirectory\\dest2.txt");
		if (src.exists()) {
			src.renameTo(dest);
			src.renameTo(dest2);
			
		}
		if (f2.isDirectory()) {
			String dir[] = f2.list();
			System.out.println("\n\n Dir Content:=====================\n");
			for (String dirs : dir) {
				System.out.println("dirs : "+dirs);
				
			}
		}
		
	}
}
