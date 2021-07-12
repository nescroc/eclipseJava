package com.sen.iopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyEx1 {
	static public void main(String args[]) {
		System.out.println("파일복사 시작");
		long start = System.currentTimeMillis();
		FileInputStream src = null;
		FileOutputStream dest = null;
		byte[] kb8 = new byte[8192];
		try {
			// 원본 파일을 읽기 위한 FileInputStream 객체 생성
			src = new FileInputStream(new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\실전가이드1.pdf"));
			// 복사본 파일을 생성하기 위한 FileOutputStream객체 생성
			dest = new FileOutputStream(new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\실전가이드3.pdf"));
			// FileInputStream의 read()메서드를 통해서 읽어들인 값을
			// readValue 에 저장
			int readValue = 0;
			while ((readValue = src.read(kb8)) != -1) {
				dest.write(kb8,0,readValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dest != null)
					dest.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (src != null)
					src.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		long copyTime = end - start;
		System.out.println("걸린 시간 : " + copyTime + "밀리초");
	}
}
