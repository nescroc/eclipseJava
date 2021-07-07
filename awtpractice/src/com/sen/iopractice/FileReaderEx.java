package com.sen.iopractice;

import java.io.FileReader;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			// ���Ϸκ��� �ѹ��� ������ �о� �ü� �ִ� FileReader��ü ����
			reader = new FileReader("C:\\\\Users\\\\nes05\\\\OneDrive\\\\���� ȭ��\\\\����\\\\Hello.txt");
			// ��Ʈ���� ���ؼ� �о���� �����ڵ尪�� ������ ����
			int readValue = 0;
			while ((readValue = reader.read()) != -1) {
				System.out.println((char) readValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try catch���� �κ�
		}
	}
}
