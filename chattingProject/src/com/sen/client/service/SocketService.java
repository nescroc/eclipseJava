package com.sen.client.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import com.sen.client.util.Config;
import com.sen.client.viewload.ViewLoader;
import com.sen.server.service.Packet;

import javafx.application.Platform;

public class SocketService {
	// 서버접속시작
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;

	public void socketInit() {
		try {			
			Config.packetDistributor = new PacketDistributor();
			Config.userInfo = new UserInfo();

			Config.socketChannel = SocketChannel.open();
			Config.socketChannel.configureBlocking(true);
			Config.socketChannel.connect(new InetSocketAddress("localhost", 10001));

			Config.userInfo.setIp(Config.socketChannel.getLocalAddress().toString());
			System.out.println(Config.userInfo.getIp());
			objectInputStream = new ObjectInputStream(Config.socketChannel.socket().getInputStream());
			objectOutputStream = new ObjectOutputStream(Config.socketChannel.socket().getOutputStream());
			
			
			
		} catch (Exception e) {
			Platform.runLater(() -> {
				ViewLoader.roomListController.roomchatArea.appendText("서버 연결 실패 \n");
			});
			e.printStackTrace();
			return;
		}
		Runnable rn = new Runnable() {
			@Override
			public void run() {

				while (true) {
					try {
						System.out.println("오나");						
						Packet packet = (Packet) objectInputStream.readObject();
						System.out.println("일루와요");
						Config.packetDistributor.packetDistribute(packet);
						System.out.println("durleadsf");
					} catch (Exception e) {
						Platform.runLater(()->{
							ViewLoader.roomListController.roomchatArea.appendText("호스트에 의해 강제로 접속이 끊겼습니다.\n");
						});
						socketDestory();
						e.printStackTrace();
						break;
					}
				}
			}
		};
		Thread thread = new Thread(rn);
		thread.start();
		

	}

	// 서버연결종료
	public void socketDestory() {
		try {
			Platform.runLater(()->{
				ViewLoader.roomListController.roomchatArea.appendText("로그아웃 성공  \n");
				ViewLoader.roomListController.createbt.setDisable(true);
				ViewLoader.roomListController.searchbt.setDisable(true);
				ViewLoader.roomListController.idLabel.setText("");
				ViewLoader.roomListController.loginbt.setText("로그인");
			});
			if (Config.socketChannel != null || Config.socketChannel.isOpen())
				Config.socketChannel.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// 발신


	public void sender(com.sen.server.service.Packet sendPacket) {
		try {
			
			objectOutputStream.writeObject(sendPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
