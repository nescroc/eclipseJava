package com.sen.iopractice;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			//파일에 저장된 객체를 읽어들이기 위해
			//ObjectInputStream 객체생성
			ois = new ObjectInputStream(
						new FileInputStream("C:\\mySen\\test\\obj.sav"));
			
			//ObjectInputStream은 스트림으로부터
			//읽어들인 직렬화된 객체를
			//역직렬화해서 객체를 생성할 수 있다.
			//역직렬화할때 필요한 클래스 파일을 찾지 못할 경우
			//ClassNotFoundException을 발생시킨다.
			Data data = (Data)ois.readObject();
			System.out.println("번호 : "+data.getNo());
			System.out.println("이름 : "+data.getName());
			System.out.println("메일 : "+data.getMail());
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			try {if (ois!=null) ois.close();				
			} catch (Exception e2) {e2.printStackTrace();}
		}
		
	}
}
