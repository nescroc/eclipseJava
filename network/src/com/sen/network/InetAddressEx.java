package com.sen.network;

import java.net.InetAddress;

public class InetAddressEx {
	public static void main(String[] args) {
		// InetAddress는 ip정보와 host정보(이름)을 가지는 객체
		// InetAddress객체는 생성자가 아닌 static 메서드를 이용해서 생성한다.

		try {
			// host이름에 해당하는 ip정보를 가진 InetAddress객체 얻기
			InetAddress ipInfo1 =
					InetAddress.getByName("www.kgitbank.co.kr");
			//ip 주소 얻기
			String ip = ipInfo1.getHostAddress();
			System.out.println("ip주소 : "+ip);
			//host이름에 해당하는 ip정보를 가진 모든 InetAddress 객체 얻기
			InetAddress[] ipArray = 
					InetAddress.getAllByName("www.kgitbank.co.kr");
			for (InetAddress inetAddress : ipArray) {
				System.out.println(inetAddress);
			}
			//현재 컴퓨터의 ip정보를 가진 InetAddress객체얻기
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println("host : "+myHost.getHostName());
			System.out.println("host IP : "+myHost.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}
