package com.sen.iopractice;

import java.io.*;

public class StreamTokenizerEx {
	public static void main(String[] args) {
		BufferedReader br = null; StreamTokenizer st =null;
		FileWriter fw = null; BufferedWriter bw = null;
		PrintWriter pw = null;
		try {//C:\mySen\test\streamToken.txt
			fw = new FileWriter("C:\\mySen\\test\\streamToken.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			pw.println(10000);pw.println("¾È³çÇÏ¼¼¿ä");
			pw.println("stdio@hanmail.net");
			pw.println("I am Instructor");pw.println("~`!@#");
			br = new BufferedReader(new FileReader("C:\\mySen\\test\\streamToken.txt"));
			st = new StreamTokenizer(br);
			while (st.nextToken()!=StreamTokenizer.TT_EOF) {
				switch (st.ttype) {
				case StreamTokenizer.TT_WORD:
					System.out.println("Word => "+st.sval);
					break;
				case StreamTokenizer.TT_NUMBER:
					System.out.println("Number => "+(int)st.nval);					
					break;

				default:
					System.out.println("No word, No Number = > " + (char)st.ttype);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(br!=null)bw.close();
				if(pw!=null)pw.close();
				if(bw!=null)bw.close();
				if(fw!=null)fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
