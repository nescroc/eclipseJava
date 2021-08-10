package com.sen.server.util;

import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

import com.sen.server.service.MultiChatRunnable;
import com.sen.server.service.UserDAO;
import com.sen.server.service.UserDTO;

public class SysInfo {
	
	/** nio ���� ���� ä�� **/
	public static ServerSocketChannel serverSocketChannel;
	/** ������ Ǯ **/
	public static ThreadPoolExecutor threadPoolExecutor;
	/** ���� �� **/
	public static ConcurrentHashMap<MultiChatRunnable, UserDTO> users;

	public static Charset charset = Charset.forName("UTF-8");

	public static UserDAO userDAO ;
	
}
