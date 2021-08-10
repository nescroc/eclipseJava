package com.sen.client.service;

import com.sen.client.util.Config;
import com.sen.client.viewload.ViewLoader;
import com.sen.server.service.Packet;
import com.sen.server.service.Protocol;

import javafx.application.Platform;

public class PacketDistributor {
	
	public void packetDistribute(Packet packet) {
		System.out.println(packet.toString() + "\n");
		switch (packet.getProtocol()) {

		case Protocol.LOGIN_SUCCESS:
			Config.userInfo.setCid(packet.getCid());
			Config.userInfo.setCno(packet.getCno());
			Config.userInfo.setCpw(packet.getCpw());
			Config.userInfo.setIp(packet.getIp());
			Platform.runLater(() -> {
				ViewLoader.roomListController.idLabel.setText(packet.getCid());
				ViewLoader.roomListController.loginbt.setText("�α׾ƿ�");
				ViewLoader.roomListController.searchbt.setDisable(false);
				ViewLoader.roomListController.createbt.setDisable(false);
			});

			break;
		case Protocol.WELCOME_TEXT:
			Platform.runLater(() -> {
				TextWriter.write("ä�ù濡 ���Ű� ȯ���մϴ�.\n");
			});
			break;
		case Protocol.JOIN_SUCCESS:			
			Platform.runLater(() -> {
				ViewLoader.loginController.stage.hide();
				ViewLoader.roomListController.idLabel.setText(packet.getCid());
				ViewLoader.roomListController.loginbt.setText("�α׾ƿ�");
				ViewLoader.roomListController.roomchatArea.appendText(packet.getCid() + " �� ȯ���մϴ�.\n");
			});
			break;
		case Protocol.LOGIN_FAIL_ID:
			Platform.runLater(()->{
				ViewLoader.loginController.resultlb.setText("���� ���̵�");
				ViewLoader.loginController.loginArea.clear();
				ViewLoader.loginController.pwdArea.clear();
			});
			break;
		case Protocol.LOGIN_FAIL_PW:
			Platform.runLater(()->{
				ViewLoader.loginController.resultlb.setText("�߸��� ��й�ȣ");
				ViewLoader.loginController.loginArea.clear();
				ViewLoader.loginController.pwdArea.clear();
			});
			break;
		case Protocol.SEND_ALL:
			Platform.runLater(()->{
				ViewLoader.roomListController.roomchatArea.appendText(packet.getCid()!=null?packet.getCid():packet.getIp()
						+" : "+packet.getMessage()+"\n");	
			});
			break;
			
		case Protocol.SEND_WHISPER:
			ViewLoader.roomListController.roomchatArea.appendText("From"+packet.getCid()+" : "+packet.getMessage());
			break;
		case Protocol.LOGIN_FAIL_BANNED:
			Platform.runLater(()->{
				ViewLoader.loginController.resultlb.setText("���ܵ� ���̵�");
				ViewLoader.loginController.loginArea.clear();
				ViewLoader.loginController.pwdArea.clear();
			});
			break;		
		}
	}

}
