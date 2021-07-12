package com.sen.iopractice;

import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\Hello.txt");
		System.out.println("파일인지 여부 : "+ file.isFile());
		System.out.println("디렉터리 인지 여부 : "+file.isDirectory()) ;
		System.out.println("상대경로 : " +file.getPath());
		System.out.println("절대경로 : " +file.getAbsolutePath());
		System.out.println("디렉터리 혹은 파일 이름  : "+file.getName());
		System.out.println("파일의 길이  : "+file.length());
		System.out.println("파일의 최종 수정 날짜 : "+file.lastModified());
	}

}
