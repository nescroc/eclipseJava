package com.sen.iopractice;

import java.io.*;

public class DataInputStreamEx {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {			
			fis = new FileInputStream("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\data.sav");
			dis = new DataInputStream(fis);
			//DataInputStream은 기본자료형을 유지한채로 저장된
			//값을 읽어들일 수 있는 read메서드가 존재한다.
			//읽어들이 때는 반드시 기록한 순서대로 읽어와야 한다.
			int i = dis.readInt();
			double d = dis.readDouble();
			String s = dis.readUTF();
			System.out.println("i값"+i);
			System.out.println("d값"+d);
			System.out.println("s값"+s);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (dis!=null) {dis.close();}
			} catch (IOException e) {}
			try {
				if (fis!=null) {fis.close();}
			} catch (IOException e) {}

		}
		
	}
	
}
