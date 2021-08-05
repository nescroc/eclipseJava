package com.sen.server.util;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class SysInfo {
	public static Connection DbConnection;
	/** nio 서버 소켓 채널**/
	public static ServerSocketChannel serverSocketChannel;
	/** 쓰레드 풀**/
	public static ThreadPoolExecutor threadPoolExecutor;
	/** 소켓 맵**/
	public static ConcurrentHashMap<SocketChannel, String> users; 
	
	public static Charset charset = Charset.forName("UTF-8");
	
	public static Properties dbprops;
}
