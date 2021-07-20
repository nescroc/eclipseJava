package com.sen.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionEx {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kgitbank.co.kr/");
			URLConnection uc = url.openConnection();
			uc.connect();
			String str = null;
			br= new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while ((str=br.readLine())!=null) {
				System.out.println(str);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(br!=null)br.close();} catch (Exception e2) {}
		}
	}
}
