package com.sen.server.util;

import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

import com.sen.server.service.MultiChatRunnable;
import com.sen.server.service.UserDAO;
import com.sen.server.service.UserDTO;

public class SysInfo {
	
	/** nio 서버 소켓 채널 **/
	public static ServerSocketChannel serverSocketChannel;
	/** 쓰레드 풀 **/
	public static ThreadPoolExecutor threadPoolExecutor;
	/** 소켓 맵 **/
	public static ConcurrentHashMap<MultiChatRunnable, UserDTO> users;

	public static Charset charset = Charset.forName("UTF-8");

	public static UserDAO userDAO ;
	
}
