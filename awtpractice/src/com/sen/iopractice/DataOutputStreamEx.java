package com.sen.iopractice;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx {
	public static void main(String[] args) {
		//DataOutputStream은 기본자료형 타입 그대로 스트림을 통해서
		//기록할 수 있다.
		//DataOutputStream은 1차스트림이 아니기 때문에 다른 스트림을 
		//이용해서 특정 Device와 연결될 수 있다
		DataOutputStream dos = null;
		FileOutputStream fos = null;
		try {
			//DataOutputStream과 연결된 FileOutputStream 객체생성
			fos = new FileOutputStream("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\data.sav");
			
			//기본자료형의 타입을 유지한채 기록할 수 있는
			//DataOutputStream 객체 생성
			dos = new DataOutputStream(fos);
			int i = 10;
			double d = 3.14;
			String s= "사랑해요";
			//DataOutputStream은 기본자료형별로  write메소드가 존재
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
