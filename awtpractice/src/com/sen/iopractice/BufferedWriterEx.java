package com.sen.iopractice;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\Hello.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter 테스트입니다.");
			bw.newLine();
			bw.write("안녕하세요 "+
					System.getProperty("line.separator"));
			bw.write("반갑습니다");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(fw!=null)fw.close();} catch (Exception e2) {}
			try {if(bw!=null)bw.close();} catch (Exception e2) {}
		}
	}
	
}
