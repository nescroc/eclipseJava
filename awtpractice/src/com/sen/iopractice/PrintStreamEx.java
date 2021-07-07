package com.sen.iopractice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		try {
			fos = new FileOutputStream("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\Hello.txt");
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos,true);
			ps.println("나일성");ps.println("1234");
			ps.println(true); ps.println('a');
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(ps!=null)ps.close();} catch (Exception e2) {}
			try {if(bos!=null)bos.close();} catch (Exception e2) {}
			try {if(fos!=null)fos.close();} catch (Exception e2) {}
		}
		
	}
}
