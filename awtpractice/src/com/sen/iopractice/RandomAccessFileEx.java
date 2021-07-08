package com.sen.iopractice;

import java.io.RandomAccessFile;

public class RandomAccessFileEx {
	public static void main(String[] args) {
		RandomAccessFile ra = null;
		try {
			ra = new RandomAccessFile("C:\\mySen\\test\\random.txt", "rw");
			String receive = "hello";
			ra.seek(ra.length());
			ra.write(receive.getBytes());
			byte[] buf = new byte[(int) ra.length()];
			ra.seek(0);
			ra.read(buf);
			System.out.print("처음 읽은 내용 : ");
			System.out.println(new String(buf));
			ra.seek(0);
			ra.read(buf);
			System.out.print("다시 읽은 내용 : ");
			System.out.println(new String(buf));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ra != null)
					ra.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}
}
