package com.sen.server.service;

import com.sen.server.util.SysInfo;
import com.sen.server.viewload.ServerViewLoader;

import javafx.application.Platform;

public class ServiceDistribution {

	public static void packetDecompose(MultiChatRunnable multiChatRunnable, Packet packet) {
		Send send = new Send();
		Packet sendPacket = null;
		switch (packet.getProtocol()) {
		case Protocol.LOGIN_REQUEST:
			sendPacket = new Packet();

			int protocol = SysInfo.userDAO.chatLogin(packet.getCid(), packet.getCpw());

			sendPacket.setProtocol(protocol);

			if (protocol == Protocol.LOGIN_SUCCESS) {
				SysInfo.users.get(multiChatRunnable).setCid(packet.getCid());
				sendPacket.setCid(packet.getCid());
			}

			send.send(multiChatRunnable, sendPacket);

			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString() + "\n");
			});
			break;

		case Protocol.LOGOUT_REQUEST:
			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString() + "\n");
			});
			SysInfo.users.get(multiChatRunnable).setCid(null);
			break;

		case Protocol.JOIN_REQUEST:
			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString() + "\n");
			});
			sendPacket = new Packet();
			if (SysInfo.userDAO.idAble(packet.getCid())) {
				sendPacket.setProtocol(Protocol.JOIN_FAIL_EXIST_ID);
				send.send(multiChatRunnable, sendPacket);

			} else {
				SysInfo.userDAO.insertUser(packet.getCid(), packet.getCpw());
				sendPacket.setProtocol(Protocol.JOIN_SUCCESS);
				sendPacket.setCid(packet.getCid());
				send.send(multiChatRunnable, sendPacket);

			}
			break;
		case Protocol.SEND_ALL:
			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString() + "\n");
			});

			break;
		case Protocol.SEND_WHISPER:
			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString());
			});
			break;

		default:
			Platform.runLater(() -> {
				ServerViewLoader.svc0.txtDisplay.appendText(packet.toString());
			});
			break;
		}
	}

}
