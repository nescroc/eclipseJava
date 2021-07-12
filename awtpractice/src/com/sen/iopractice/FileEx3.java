package com.sen.iopractice;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args) throws IOException {
		// 파일생성
		File f1 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newFile.txt");
		if (f1.exists()) {
			System.out.println("파일이름 : " + f1.getName());
		} else {
			// IOException 발생
			if (f1.createNewFile()) {
				System.out.println("새로운 파일을 만들었습니다.");
			}
		}
		File f2 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newDirectory");
		if (!f2.exists())
			f2.mkdir();
		else 
			System.out.println("디렉터리 이름 : "+f2.getPath());
		
		/*
		 * File f3 = new
		 * File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newFile.txt"); if
		 * (f3.exists()) f3.delete();
		 */		
		//파일 혹은 디렉터리 이름변경
		File src = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newFile.txt");
		File dest = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newDirectory");
		File dest2 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\dest\\newDirectory\\desc2.txt");
		if (src.exists()) {
			src.renameTo(dest);
			src.renameTo(dest2);
		}
		
		
		if (f2.isDirectory()) {//디렉터리의 목록을 출력함
			String dir[] = f2.list();
			System.err.println("\n\n Dir Content ====================\n");
			for (String dirs : dir) {
				System.out.println("dirs : "+dirs);
			}
			
		}
	}

}
