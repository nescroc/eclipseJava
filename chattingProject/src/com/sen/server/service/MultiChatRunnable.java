package com.sen.server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;

import com.sen.server.util.SysInfo;
import com.sen.server.viewload.ServerViewLoader;

public class MultiChatRunnable implements Runnable {
	
	public SocketChannel socketChannel;	
	public UserDTO userDTO;
	public ObjectInputStream objectInputStream;
	public ObjectOutputStream objectOutputStream;
	
	public MultiChatRunnable(SocketChannel socketChannel, UserDTO userDTO) {
		this.socketChannel = socketChannel;
		this.userDTO = userDTO;		
		SysInfo.users.put(this, this.userDTO);
	}
	@Override
	public void run() {

		try {			
			objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
			objectOutputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
			while (true) {
				Packet packet = (Packet)objectInputStream.readObject();  				
				// Log.receive(socketChannel, Thread.currentThread().getName());
				
				System.out.println(packet.getProtocol());
				
				ServiceDistribution.packetDecompose(this, packet);
				
				//Protocol과 Object를 써서 구현할것
				
				
				/*
				 * ServerViewLoader.svc0.updateStatus(); if (d != null) {
				 * SysInfo.users.put(socketChannel, ip);
				 * System.out.println(SysInfo.users.toString());
				 * 
				 * 
				 * }
				 */
				
					
								 
				//send.sendAll(socketChannel, d);
			}
		} catch (IOException e) {					
			SysInfo.users.remove(this);					
			ServerViewLoader.svc0.updateStatus();					
			try {if(socketChannel.isOpen())socketChannel.close();}
							catch (IOException ioe) {}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("패킷전송실패");
			cnfe.printStackTrace();
		}
	}
	
}
