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
				ViewLoader.roomListController.loginbt.setText("로그아웃");
				ViewLoader.roomListController.searchbt.setDisable(false);
				ViewLoader.roomListController.createbt.setDisable(false);
			});

			break;
		case Protocol.WELCOME_TEXT:
			Platform.runLater(() -> {
				TextWriter.write("채팅방에 오신걸 환영합니다.\n");
			});
			break;
		case Protocol.JOIN_SUCCESS:			
			Platform.runLater(() -> {
				ViewLoader.loginController.stage.hide();
				ViewLoader.roomListController.idLabel.setText(packet.getCid());
				ViewLoader.roomListController.loginbt.setText("로그아웃");
				ViewLoader.roomListController.roomchatArea.appendText(packet.getCid() + " 님 환영합니다.\n");
			});
			break;
		case Protocol.LOGIN_FAIL_ID:
			Platform.runLater(()->{
				ViewLoader.loginController.resultlb.setText("없는 아이디");
				ViewLoader.loginController.loginArea.clear();
				ViewLoader.loginController.pwdArea.clear();
			});
			break;
		case Protocol.LOGIN_FAIL_PW:
			Platform.runLater(()->{
				ViewLoader.loginController.resultlb.setText("잘못된 비밀번호");
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
				ViewLoader.loginController.resultlb.setText("차단된 아이디");
				ViewLoader.loginController.loginArea.clear();
				ViewLoader.loginController.pwdArea.clear();
			});
			break;		
		}
	}

}
