package com.sen.server.service;

import com.sen.server.util.LogWriter;
import com.sen.server.util.SysInfo;

public class ServiceDistribution {

	public static void packetDecompose(MultiChatRunnable multiChatRunnable, Packet packet) {
		LogWriter.logWrite(packet);
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
			
			break;

		case Protocol.LOGOUT_REQUEST:
			SysInfo.users.get(multiChatRunnable).setCid(null);
			break;

		case Protocol.JOIN_REQUEST:
		
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
			send.sendAll(multiChatRunnable, sendPacket);			
			break;
		case Protocol.SEND_WHISPER:
			send.whisper(multiChatRunnable, sendPacket);			
			break;
		default:
		
			break;
		}
	}

}
