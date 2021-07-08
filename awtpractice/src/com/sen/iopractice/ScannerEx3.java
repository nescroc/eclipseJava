package com.sen.iopractice;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScannerEx3 {
	public static void main(String[] args) {
		URLConnection urlCon = null;
		Scanner scan = null;
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
			try {
				if (scan != null)
					scan.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
