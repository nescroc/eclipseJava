package com.sen.iopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyEx1 {
	public static void main(String[] args) {
		System.out.println("파일복사 시작");
		long start = System.currentTimeMillis();
		
		FileInputStream src = null;
		FileOutputStream dest= null;
		try {
				//원본 파일을 읽기 위한 FileInputStream 객체 생성
			src = new FileInputStream(new File("C:\\Users\\nes05\\"+
				"OneDrive\\바탕 화면\\수업\\실전가이드1.pdf"));
			//복사본 파일을 생성하기 위한 FileOutputStream 객체 생성
			dest = new FileOutputStream(new File("C:\\Users\\nes05\\"+
					"OneDrive\\바탕 화면\\수업\\dest\\실전가이드1.pdf"));
			//FileInputStream을 통해서 읽어들인 값을 저장할 변수
			byte[] readValue = new byte[8000];
			//FileInputStream의 read()메서드를 통해서 읽어들인 값을
			//readValue에 저장
			while ((src.read(readValue))!=-1) {
				//readValue에 저장된 값을 FileOutputStream의 write()
				//메서드를 통해서 파일에 기록
				dest.write(readValue);				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (dest!=null)dest.close(); 
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			try {
				if (src!=null)src.close(); 
			} catch (IOException e2) {
				e2.printStackTrace();
			}			
		}
		long end = System.currentTimeMillis();
		long copyTime = end - start;
		System.out.println("걸린 시간  : "+copyTime);
	}
}
