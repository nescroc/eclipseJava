package com.sen.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ULREx {
	public static void main(String[] args) {
		// URL(uniform resource locator)�� ���� ������ ������ �ִ� Ŭ����
		BufferedReader br = null;
		try {
			URL url = new URL("http://www.kgitbank.co.kr/");
			// url��ü�κ��� ��������, ȣ��Ʈ��, ��Ʈ��ȣ,
			// �ڿ��� ���, ������Ʈ������ ���� �� �ִ�.
		
			
			//url�� ����Ű�� �ڿ��� ����� inputStream ����
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
			System.out.println("�������� : " + url.getProtocol());
			System.out.println("ȣ��Ʈ : " + url.getHost());
			System.out.println("��Ʈ��ȣ  : " + url.getPort());
			System.out.println("���  : " + url.getPath());
			System.out.println("���� : " + url.getFile());
		} catch (MalformedURLException e) {
			//�߸��� url�� ��� MalformedURLException�� �߻���Ų��.
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			try {if(br!=null)br.close();} catch (Exception e) {}	
			
		}
	}
}
