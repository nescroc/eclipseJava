package com.sen.client.util;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.sen.client.service.PacketDistributor;
import com.sen.client.service.SocketService;
import com.sen.client.service.UserInfo;

public class Config {
	public static SocketChannel socketChannel;
	/** BUFFER **/
	
	public static ByteBuffer byteBuffer;
	public static UserInfo userInfo;
	// public static ConcurrentHashMap<, V>
	
	
	public static PacketDistributor packetDistributor;
	public static SocketService socketService;
}
