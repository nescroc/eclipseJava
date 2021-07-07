package com.sen.iopractice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterEx {
	public static void main(String[] args) {
		PrintWriter pw = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\Hello.txt");
			bos = new BufferedOutputStream(fos);
			pw = new PrintWriter(bos,true);
			pw.println("안녕하세여!!");
			pw.println("또 만났네요.");
			pw.println(100.0);
			pw.println(new Boolean(true));
			
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {	
				if (pw!=null) {pw.close();}
				if (bos!=null) {bos.close();}
				if (fos!=null) {fos.close();}
				} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}

