package com.sen.iopractice;

import java.io.FileReader;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			// 파일로부터 한문자 단위로 읽어 올수 있는 FileReader객체 생성
			reader = new FileReader("C:\\\\Users\\\\nes05\\\\OneDrive\\\\바탕 화면\\\\수업\\\\Hello.txt");
			// 스트림을 통해서 읽어들인 유니코드값을 저장할 변수
			int readValue = 0;
			while ((readValue = reader.read()) != -1) {
				System.out.println((char) readValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try catch종료 부분
		}
	}
}
