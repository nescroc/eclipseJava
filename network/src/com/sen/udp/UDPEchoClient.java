package com.sen.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

	private String str;
	private BufferedReader file;
	private static int SERVERPORT = 3000;
	DatagramSocket ds = null;
	public UDPEchoClient(String ip,int port) {
		try {
			InetAddress ia = InetAddress.getByName(ip);
			 ds = new DatagramSocket(port);
			System.out.println("message : ");
			file = new BufferedReader(
					new InputStreamReader(System.in));
			str = file.readLine();
			byte buffer[] = str.getBytes();
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length
					,ia,SERVERPORT);
			ds.send(dp);
			buffer = new byte[512];
			dp = new DatagramPacket(buffer,buffer.length);
			ds.receive(dp);
			System.out.println("server ip : "+dp.getAddress()
								+", server port : "+dp.getPort());
			System.out.println("수신된 데이터 : "+
								new String(dp.getData()).trim());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (ds!=null)ds.close(); 
		}
	}
	
	public static void main(String[] args) {
		new UDPEchoClient("localhost",5000);
	}

}
