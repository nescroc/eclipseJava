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
		this.userDTO.setCid("root");
		SysInfo.users.put(this, this.userDTO);
		
	}
	@Override
	public void run() {

		try {			
			
			
			while (true) {
				objectOutputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
				objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
				Packet packet = (Packet)objectInputStream.readObject();  				
				// Log.receive(socketChannel, Thread.currentThread().getName());
				
				System.out.println(packet.getProtocol());
				System.out.println(12345);
				ServiceDistribution.packetDecompose(this, packet);
				System.out.println("6789");
			}
		} catch (IOException e) {					
			SysInfo.users.remove(this);					
			ServerViewLoader.svc0.updateStatus();					
			try {if(socketChannel.isOpen())socketChannel.close();}
							catch (IOException ioe) {}
		} catch (ClassNotFoundException cnfe) {}
	}
	
}
