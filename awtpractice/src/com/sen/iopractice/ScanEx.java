package com.sen.iopractice;

import java.io.File;
import java.util.Scanner;

public class ScanEx {
	public static void main(String[] args) {
		Scanner scan = null;
		try {

			scan = new Scanner(new File("C:\\mySen\\test\\Hello.txt"));

			while (scan.hasNext()) {

				System.out.println(scan.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
		}
	}
}
