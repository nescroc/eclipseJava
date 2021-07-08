package com.sen.iopractice;

import java.io.File;
import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\mySen\\test\\scan.txt"));
					while (scan.hasNextDouble()) {
						System.out.printf("½ºÄµ double : %.2f %n",scan.nextDouble());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					scan.close();
				}
	}
}
