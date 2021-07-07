package com.sen.iopractice;

import java.io.File;
import java.io.IOException;

public class FileEx3 {
	public static void main(String[] args)  {
		//파일생성
		File f1 = new File
				("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
							+"수업\\test\\newFile.txt");//빈 파일이 만들어짐
		if (f1.exists()) {
			System.out.println("파일이름"+f1.getName());
		}else {
			//IOException 발생
			try {
				if (f1.createNewFile()) {					
					System.out.println("새로운 파일을 만들었습니다.");
					}				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		//디렉터리 생성
		File f2 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
							+"수업\\test\\newDirectory");
		if (!f2.exists()) {
			f2.mkdir();
		}else {
			System.out.println("디렉터리 이름 : "+f2.getPath());
			System.out.println("디렉터리 이름 : "+f2.getAbsolutePath());
		}
		
		//파일 혹은 디렉터리 삭제
//		File f3 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
//							+"수업\\test\\newDirectory");
//		
//		if (f3.exists()) {
//			f3.delete()
//		}
		
		File src = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
					+"수업\\test\\newDirectory\\newFile2.txt");
		File dest = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
					+"수업\\test\\newDirectory\\dest.txt");
		File dest2 = new File("C:\\Users\\nes05\\OneDrive\\바탕 화면\\"
							+"수업\\test\\newDirectory\\dest2.txt");
		if (src.exists()) {
			src.renameTo(dest);
			src.renameTo(dest2);
			
		}
		if (f2.isDirectory()) {
			String dir[] = f2.list();
			System.out.println("\n\n Dir Content:=====================\n");
			for (String dirs : dir) {
				System.out.println("dirs : "+dirs);
				
			}
		}
		
	}
}
