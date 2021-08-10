package com.sen.client.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import com.sen.client.util.Config;
import com.sen.client.viewload.ViewLoader;
import com.sen.server.service.Packet;
import com.sen.server.service.Protocol;

import javafx.application.Platform;

public class SocketService {
	// 서버접속시작
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	public void socketInit() {
		try {
			Config.packetDistributor = new PacketDistributor();
			Config.socketChannel = SocketChannel.open();

			Config.socketChannel.configureBlocking(true);
			Config.socketChannel.connect(new InetSocketAddress("localhost", 10001));
			
			objectOutputStream = new ObjectOutputStream(Config.socketChannel.socket().getOutputStream());
			objectInputStream = new ObjectInputStream(Config.socketChannel.socket().getInputStream());
			
			
			Packet packet = new Packet(); 
			packet.setProtocol(Protocol.JOIN_REQUEST);
			packet.setCid("369369");
			packet.setCpw("369369");
			objectOutputStream.writeObject(packet);
			
			
		} catch (Exception e) {
			Platform.runLater(()->{				
				ViewLoader.roomListController.roomchatArea.appendText("서버 연결 실패 \n");
			});
			return;
		}
		receiver();

	}

	// 서버연결종료
	public void socketDestory() {
		try {
			if (Config.socketChannel != null || Config.socketChannel.isOpen())
				Config.socketChannel.close();
		} catch (IOException ioe) {	ioe.printStackTrace();}
	}

	// 발신
	

	// 수신
	public  void receiver() {
		Runnable rn = new Runnable() {
			@Override
			public void run() {				
				while (true) {
					try {						
						System.out.println("receiver 2 while");
										
						Packet packet = (Packet)objectInputStream.readObject();
						Config.packetDistributor.packetDistribute(packet);
						System.out.println("정상작동");
					} catch (Exception e) {
						break;
					}
				}
			}
		};
		Thread thread = new Thread(rn);
		thread.start();

	}
	public  void  sender(com.sen.server.service.Packet sendPacket) {
		try {		
			objectOutputStream.writeObject(sendPacket);
			objectOutputStream.flush();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
