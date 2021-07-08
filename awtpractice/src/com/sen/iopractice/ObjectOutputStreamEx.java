package com.sen.iopractice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			//�޸𸮿� ������ ��ü�� ����ȭ�ؼ� ��Ʈ��������
			//����� �� �ִ� ObjectOutputStream ��ü ����
			oos = new ObjectOutputStream(
						new FileOutputStream("C:\\mySen\\test\\obj.sav"));
			//ObjectOutputStream�� ���ؼ� ����ȭ�� �� ���Ϸ� ��ϵ� Data
			//��ü���� DataŬ������ �ݵ�� serializable�� �����ϰ� �־���Ѵ�.
			Data data = new Data();
			data.setNo(33);
			data.setName("���ϼ�");
			data.setMail("darkcp9@naver.com");
			//ObjectOutputStream�� ��ü�� ����ȭ�ؼ� ��Ʈ����
			//���� ����Ҽ� �ִ� writeObject()�޼��带 �����Ѵ�.
	
			oos.writeObject(data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (oos!=null)oos.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
