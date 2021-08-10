package com.sen.client.service;

import com.sen.client.util.Config;
import com.sen.client.viewload.ViewLoader;
import com.sen.server.service.Packet;
import com.sen.server.service.Protocol;

import javafx.application.Platform;

public class PacketDistributor {
	
	
	public PacketDistributor() {
		
	}
	
	public void packetDistribute(Packet packet) {
		System.out.println(packet.toString()+"\n");
		switch (packet.getProtocol()) {
		
		case Protocol.LOGIN_SUCCESS:
			Config.userDTO.setCid(packet.getCid());
			Config.userDTO.setCno(packet.getCno());
			Config.userDTO.setCpw(packet.getCpw());
			Config.userDTO.setIp(packet.getIp());
			Platform.runLater(()->{
				ViewLoader.roomListController.idLabel.setText(packet.getCid());
				ViewLoader.roomListController.loginbt.setText("�α׾ƿ�");
				ViewLoader.roomListController.searchbt.setDisable(false);
				ViewLoader.roomListController.createbt.setDisable(false);
			});
	
			break;
		case Protocol.WELCOME_TEXT:
			Platform.runLater(()->{
				TextWriter.write("ä�ù濡 ���Ű� ȯ���մϴ�.\n");
			});
		
		case Protocol.JOIN_SUCCESS:
			System.out.println("���������");
			Platform.runLater(()->{
				ViewLoader.loginController.stage.hide();
				ViewLoader.roomListController.idLabel.setText(packet.getCid());
				ViewLoader.roomListController.loginbt.setDisable(true);
				ViewLoader.roomListController.roomchatArea.appendText(packet.getCid()+" �� ȯ���մϴ�.\n");
			});
		case Protocol.LOGIN_FAIL_ID:
			
		
		default:
			break;
		}
	}
	

}
