package com.sen.server.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.stream.Stream;

import com.sen.server.util.SysInfo;
import com.sen.server.viewload.ServerViewLoader;

public class Send {
	/** 송신 : 일반채팅 **/
	public void sendAll(MultiChatRunnable multiChatRunnable, Packet sendPacket) {

		Set<MultiChatRunnable> keySet = SysInfo.users.keySet();
		Stream<MultiChatRunnable> keySetStream = keySet.parallelStream();
		keySetStream.forEach(k -> {
			send(k, sendPacket);
		});
	}

	public void send(MultiChatRunnable multiChatRunnable, Packet sendPacket) {
		/** 송신 : 개인 **/
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {					
					System.out.println("살려주세요");
					multiChatRunnable.objectOutputStream.writeObject(sendPacket);
					System.out.println("해치웠나?");
					// Log.send(socketChannel, Thread.currentThread().getName());

				} catch (Exception e) {
					try {
						SysInfo.users.remove(multiChatRunnable);
						// Log.disconnect(socketChannel, Thread.currentThread().getName());
						ServerViewLoader.svc0.updateStatus();
						multiChatRunnable.socketChannel.close();
					} catch (IOException ioe) {
					}
				}
			}
		};
		SysInfo.threadPoolExecutor.submit(runnable);
	}

	/** 귓속말 **/
	public void whisper(MultiChatRunnable multichatRunnable, Packet sendPacket) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			
			MultiChatRunnable toRunnable = Finder.socket(sendPacket.getToId());
			if (toRunnable != null) {

				objectOutputStream.writeObject(sendPacket);
				objectOutputStream.flush();
				toRunnable.socketChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
			}else {
				Packet failPacket = new Packet();
				failPacket.setProtocol(Protocol.WHiSPER_FAIL);
				objectOutputStream.writeObject(failPacket);
				objectOutputStream.flush();
				multichatRunnable.socketChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
			}
		} catch (Exception e) {}
	}
}
