package com.sen.iopractice;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			//���Ͽ� ����� ��ü�� �о���̱� ����
			//ObjectInputStream ��ü����
			ois = new ObjectInputStream(
						new FileInputStream("C:\\mySen\\test\\obj.sav"));
			
			//ObjectInputStream�� ��Ʈ�����κ���
			//�о���� ����ȭ�� ��ü��
			//������ȭ�ؼ� ��ü�� ������ �� �ִ�.
			//������ȭ�Ҷ� �ʿ��� Ŭ���� ������ ã�� ���� ���
			//ClassNotFoundException�� �߻���Ų��.
			Data data = (Data)ois.readObject();
			System.out.println("��ȣ : "+data.getNo());
			System.out.println("�̸� : "+data.getName());
			System.out.println("���� : "+data.getMail());
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			try {if (ois!=null) ois.close();				
			} catch (Exception e2) {e2.printStackTrace();}
		}
		
	}
}
