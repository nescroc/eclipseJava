package com.sen.iopractice;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx {
	public static void main(String[] args) {
		//DataOutputStream�� �⺻�ڷ��� Ÿ�� �״�� ��Ʈ���� ���ؼ�
		//����� �� �ִ�.
		//DataOutputStream�� 1����Ʈ���� �ƴϱ� ������ �ٸ� ��Ʈ���� 
		//�̿��ؼ� Ư�� Device�� ����� �� �ִ�
		DataOutputStream dos = null;
		FileOutputStream fos = null;
		try {
			//DataOutputStream�� ����� FileOutputStream ��ü����
			fos = new FileOutputStream("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\dest\\data.sav");
			
			//�⺻�ڷ����� Ÿ���� ������ä ����� �� �ִ�
			//DataOutputStream ��ü ����
			dos = new DataOutputStream(fos);
			int i = 10;
			double d = 3.14;
			String s= "����ؿ�";
			//DataOutputStream�� �⺻�ڷ�������  write�޼ҵ尡 ����
			dos.writeInt(i);
			dos.writeDouble(d);
			dos.writeUTF(s);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {if(dos!=null)dos.close();
					 if(fos!=null)fos.close();} 
				catch (IOException ioe)	{ioe.printStackTrace();	}
		}
		
	}
}
