package com.sen.client.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.sen.client.service.PacketDistributor;
import com.sen.client.service.Send;
import com.sen.client.service.SocketService;
import com.sen.client.service.UserDTO;

public class Config {
	public static SocketChannel socketChannel;
	/** BUFFER **/
	
	public static ByteBuffer byteBuffer;
	public static UserDTO userDTO;
	// public static ConcurrentHashMap<, V>
	public static ObjectInputStream objectInputStream;	
	public static ObjectOutputStream objectOutputStream;
	public static Send send;
	public static PacketDistributor packetDistributor;
	public static SocketService socketService;
}
