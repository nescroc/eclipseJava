package com.sen.iopractice;

import java.util.Scanner;

public class ScannerEx1 {
		public static void main(String[] args) {
			System.out.print("�Է� : ");
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
			System.out.printf("��ĵ : %d",number);
			scan.close();
		}
}
