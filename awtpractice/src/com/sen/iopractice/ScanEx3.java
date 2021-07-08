package com.sen.iopractice;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScanEx3 {
	public static void main(String[] args) {
		Scanner scan = null;
		URLConnection urlCon = null;
		try {
			urlCon = new URL("http://kgitbank.co.kr").openConnection();
			scan = new Scanner(urlCon.getInputStream());
			scan.useDelimiter("\\Z");
			String text = scan.next();
			System.out.println(text);
			System.out.println(text.length());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scan != null)
				scan.close();
			
		}
	}
}
