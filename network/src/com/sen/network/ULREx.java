package com.sen.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ULREx {
	public static void main(String[] args) {
		// URL(uniform resource locator)에 대한 정보를 가지고 있는 클래스
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kgitbank.co.kr/");
			// url객체로부터 프로토콜, 호스트명, 포트번호,
			// 자원의 경로, 쿼리스트링등을 얻을 수 있다.
		
			
			//url이 가르키는 자원과 연결된 inputStream 개설
			//InputStream is = url.openStream();
			br = new BufferedReader(
					new InputStreamReader(url.openStream()));
			
			String str = null;
			int x = 0;
			while ((str=br.readLine())!=null) {
				System.out.println(str);			
				x++;
			}
			System.out.println(x);
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("포트번호  : " + url.getPort());
			System.out.println("경로  : " + url.getPath());
			System.out.println("파일 : " + url.getFile());
		} catch (MalformedURLException e) {
			//잘못된 url인 경우 MalformedURLException을 발생시킨다.
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {if(br!=null)br.close();} catch (Exception e) {}	
			
		}
	}
}
