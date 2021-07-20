package com.sen.network;

import java.net.InetAddress;

public class InetAddressEx {
	public static void main(String[] args) {
		// InetAddress�� ip������ host����(�̸�)�� ������ ��ü
		// InetAddress��ü�� �����ڰ� �ƴ� static �޼��带 �̿��ؼ� �����Ѵ�.

		try {
			// host�̸��� �ش��ϴ� ip������ ���� InetAddress��ü ���
			InetAddress ipInfo1 =
					InetAddress.getByName("www.kgitbank.co.kr");
			//ip �ּ� ���
			String ip = ipInfo1.getHostAddress();
			System.out.println("ip�ּ� : "+ip);
			//host�̸��� �ش��ϴ� ip������ ���� ��� InetAddress ��ü ���
			InetAddress[] ipArray = 
					InetAddress.getAllByName("www.kgitbank.co.kr");
			for (InetAddress inetAddress : ipArray) {
				System.out.println(inetAddress);
			}
			//���� ��ǻ���� ip������ ���� InetAddress��ü���
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println("host : "+myHost.getHostName());
			System.out.println("host IP : "+myHost.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}
