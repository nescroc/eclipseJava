package com.sen.iopractice;

import java.io.FileWriter;

public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter writer =null;
		try {
			//���Ͽ� �� ���� ������ ����� �� �ִ� FileWriter��ü����
			writer = new FileWriter("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\Hello.txt");
			//writer�� ���ڿ��� �ٷ� ����� �� �ִ�.
			String str = "������������";
			writer.write(str);
			//�Ϥ��� ���� ������ �а� ���� �ִ� Reader, Writer�迭��
			//��Ʈ���� ���������� ���۸� �����ϰ� �ִ�.
			//����� ������ ���۰� ���� ä�� �� ������ ��Ʈ���� ����
			//��������.flush()�� ���۰� �������� �ʾƵ� ���� �Ѵ�.
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (writer!=null)writer.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
