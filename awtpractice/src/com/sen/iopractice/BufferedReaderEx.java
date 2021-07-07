package com.sen.iopractice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader isr = null;		
		BufferedReader br = null;
		try {
			fis = new FileInputStream("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\Hello.txt");
			isr = new InputStreamReader(fis);
			br  = new BufferedReader(isr);
			//�� ���ξ� �о���� ���ڿ��� ������ ����
			String str = null;
			//readLine() ���๮�ڸ� ������ ���๮�� ����������
			//���ڿ��� ��ȯ�ϰ� ��Ʈ���� ���� �����ϸ� null�� ��ȯ
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(br!=null)br.close();} catch (Exception e2) {}
			try {if(isr!=null)isr.close();} catch (Exception e2) {}
			try {if(fis!=null)fis.close();} catch (Exception e2) {}
		}
	}
}
