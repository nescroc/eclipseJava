package com.sen.iopractice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx {
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			//메모리에 생성된 객체를 직렬화해서 스트림을통해
			//기록할 수 있는 ObjectOutputStream 객체 생성
			oos = new ObjectOutputStream(
						new FileOutputStream("C:\\mySen\\test\\obj.sav"));
			//ObjectOutputStream을 통해서 직렬화된 후 파일로 기록될 Data
			//객체생성 Data클래스는 반드시 serializable을 구현하고 있어야한다.
			Data data = new Data();
			data.setNo(33);
			data.setName("나일성");
			data.setMail("darkcp9@naver.com");
			//ObjectOutputStream을 객체를 직렬화해서 스트림을
			//통해 기록할수 있는 writeObject()메서드를 제공한다.
	
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
