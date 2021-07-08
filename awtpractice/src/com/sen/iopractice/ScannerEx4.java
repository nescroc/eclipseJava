package com.sen.iopractice;

import java.util.Scanner;

public class ScannerEx4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String str = "1 and 2 and animal and lion and tiger";
		Scanner scan = new Scanner(str);
		scan = scan.useDelimiter("\\s*and\\s*");
		
		int firstToken = scan.nextInt();
		int secondToken = scan.nextInt();
		String thirdToken = scan.next();
		String fourthToken = scan.next();
		String fifthToken = scan.next();
		System.out.println("firstToken : "+firstToken);
		System.out.println("secondToken : "+secondToken);
		System.out.println("thirdToken : "+thirdToken);
		System.out.println("fourthToken : "+fourthToken);
		System.out.println("fifthToken : "+fifthToken);
		
		scan.close();
	}
}
