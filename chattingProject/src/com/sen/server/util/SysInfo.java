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
	/** nio ���� ���� ä��**/
	public static ServerSocketChannel serverSocketChannel;
	/** ������ Ǯ**/
	public static ThreadPoolExecutor threadPoolExecutor;
	/** ���� ��**/
	public static ConcurrentHashMap<SocketChannel, String> users; 
	
	public static Charset charset = Charset.forName("UTF-8");
	
	public static Properties dbprops;
}
