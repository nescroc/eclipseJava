package com.sen.iopractice;

import java.io.FileWriter;

public class FileWriterEx {
	public static void main(String[] args) {
		FileWriter writer =null;
		try {
			//파일에 한 문자 단위로 기록할 수 있는 FileWriter객체생성
			writer = new FileWriter("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\Hello.txt");
			//writer는 문자열을 바로 기록할 수 있다.
			String str = "ㅋㅋㅋㅋㅋㅋ";
			writer.write(str);
			//하ㅏㄴ 글자 단위로 읽고 쓸수 있는 Reader, Writer계열의
			//스트림은 내부적으로 버퍼를 내장하고 있다.
			//내장된 버프는 버퍼가 가득 채워 질 때에만 스트림을 통해
			//내보낸다.flush()는 버퍼가 가득차지 않아도 비우게 한다.
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (writer!=null)writer.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
