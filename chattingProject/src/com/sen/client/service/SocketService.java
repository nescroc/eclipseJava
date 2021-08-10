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
	// �������ӽ���
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
				ViewLoader.roomListController.roomchatArea.appendText("���� ���� ���� \n");
			});
			e.printStackTrace();
			return;
		}
		Runnable rn = new Runnable() {
			@Override
			public void run() {

				while (true) {
					try {
						System.out.println("����");						
						Packet packet = (Packet) objectInputStream.readObject();
						System.out.println("�Ϸ�Ϳ�");
						Config.packetDistributor.packetDistribute(packet);
						System.out.println("durleadsf");
					} catch (Exception e) {
						Platform.runLater(()->{
							ViewLoader.roomListController.roomchatArea.appendText("ȣ��Ʈ�� ���� ������ ������ ������ϴ�.\n");
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

	// ������������
	public void socketDestory() {
		try {
			Platform.runLater(()->{
				ViewLoader.roomListController.roomchatArea.appendText("�α׾ƿ� ����  \n");
				ViewLoader.roomListController.createbt.setDisable(true);
				ViewLoader.roomListController.searchbt.setDisable(true);
				ViewLoader.roomListController.idLabel.setText("");
				ViewLoader.roomListController.loginbt.setText("�α���");
			});
			if (Config.socketChannel != null || Config.socketChannel.isOpen())
				Config.socketChannel.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// �߽�


	public void sender(com.sen.server.service.Packet sendPacket) {
		try {
			
			objectOutputStream.writeObject(sendPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
