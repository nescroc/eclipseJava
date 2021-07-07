package com.sen.iopractice;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterEx {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\Hello.txt");
			bw = new BufferedWriter(fw);
			bw.write("BufferedWriter �׽�Ʈ�Դϴ�.");
			bw.newLine();
			bw.write("�ȳ��ϼ��� "+
					System.getProperty("line.separator"));
			bw.write("�ݰ����ϴ�");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(fw!=null)fw.close();} catch (Exception e2) {}
			try {if(bw!=null)bw.close();} catch (Exception e2) {}
		}
	}
	
}
