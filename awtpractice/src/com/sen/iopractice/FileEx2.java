package com.sen.iopractice;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업");
		if (directory.isDirectory()) {
			String[] fileNameList = directory.list();
			for(String fileName : fileNameList )System.out.println("파일 이름 : "+fileName);
			}
	}
}
