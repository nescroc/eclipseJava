package com.sen.iopractice;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		File directory = new File("C:\\Users\\nes05\\OneDrive\\"
				+"바탕 화면\\수업\\test");
		if (directory.exists()) {
			if (directory.isDirectory()) {
				// 현재 디렉터리의 모든 파일 디렉토리의 이름얻기
				String[] fileNameList = directory.list();
				for (String fileName : fileNameList) {
					File myfile = new File(directory, fileName);
					if (myfile.isDirectory()) {
						System.out.println("폴더 이름 : " + myfile.getName());
					} else {
						System.out.println("파일 이름 : " + myfile.getName() 
						+ " 파일 크기 : " + myfile.length() + " bytes");
					}
				}

			}
		}
	}
}
