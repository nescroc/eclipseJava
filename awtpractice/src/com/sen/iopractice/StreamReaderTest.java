package com.sen.iopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {
	public static void main(String[] args) {

		FileInputStream fis = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try {
			fis = new FileInputStream(new File("C:\\Users\\nes05\\OneDrive\\" + "바탕 화면\\수업\\Hello.txt"));
			isr = new InputStreamReader(fis);
			osw = new OutputStreamWriter(System.out);
			char[] buffer = new char[512];
			int readcount = 0;
			
			
			while ((readcount = isr.read(buffer)) != -1) {
				
				osw.write(buffer, 0, readcount);
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				isr.close();
				osw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
