package com.sen.server.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.stream.Stream;

import com.sen.server.util.SysInfo;
import com.sen.server.viewload.ServerViewLoader;

public class Send {
	/** �۽� : �Ϲ�ä�� **/
	public void sendAll(MultiChatRunnable multiChatRunnable, Packet sendPacket) {
		Runnable rn = new Runnable() {

			@Override
			public void run() {
				Set<MultiChatRunnable> keySet = SysInfo.users.keySet();
				Stream<MultiChatRunnable> keySetStream = keySet.parallelStream();
				keySetStream.forEach(k -> {
					send(k, sendPacket);
				});
			}
		};
		SysInfo.threadPoolExecutor.submit(rn);
	}

	public void send(MultiChatRunnable multiChatRunnable, Packet sendPacket) {
		/** �۽� : ���� **/
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
				ObjectOutputStream	objectOutputStream = new ObjectOutputStream(multiChatRunnable.socketChannel.socket().getOutputStream());
						objectOutputStream.writeObject(sendPacket);
					System.out.println("sendPacket�Ϸ�");
				} catch (Exception e) {
					try {
						SysInfo.users.remove(multiChatRunnable);
						ServerViewLoader.svc0.updateStatus();
						multiChatRunnable.socketChannel.close();
					} catch (IOException ioe) {
					}
				}
			}
		};
		System.out.println(sendPacket.toString());
		SysInfo.threadPoolExecutor.submit(runnable);
	}

	/** �ӼӸ� **/
	public void whisper(MultiChatRunnable multichatRunnable, Packet sendPacket) {
		try {

			MultiChatRunnable toRunnable = Finder.socket(sendPacket.getToId());
			if (toRunnable != null) {
				toRunnable.objectOutputStream.writeObject(sendPacket);
			} else {
				Packet failPacket = new Packet();
				failPacket.setProtocol(Protocol.WHiSPER_FAIL);
				multichatRunnable.objectOutputStream.writeObject(failPacket);
			}
		} catch (Exception e) {
		}
	}
}
