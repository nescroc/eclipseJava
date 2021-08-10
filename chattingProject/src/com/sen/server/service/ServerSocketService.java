package com.sen.server.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.sen.server.util.SysInfo;
import com.sen.server.viewload.ServerViewLoader;

import javafx.application.Platform;

public class ServerSocketService {

	class SocketListener implements Runnable {

		@Override
		public void run() {
							
				//3번생성				
				SysInfo.users = new ConcurrentHashMap<MultiChatRunnable, UserDTO>();
				while (true) {
					try {
						SocketChannel socketChannel = SysInfo.serverSocketChannel.accept();
						String ip = socketChannel.getRemoteAddress().toString();						/*
						 * 블랙리스트 todo if(QueryBase.selectBlacklist(ip)) { socketChannel.close();
						 * continue; }
						 */
						System.out.println(ip);
						//SysInfo.users.put(socketChannel, ip);
						UserDTO userDTO = new UserDTO();
						userDTO.setIp(ip);
						
						receive(socketChannel, userDTO);
						ServerViewLoader.svc0.updateStatus();
						System.out.println("접속 갱신");
					} catch (IOException e) {
						if (SysInfo.serverSocketChannel.isOpen()) 
									serverStop(); break;
						
					}
				}
			
		}

	}

	/*
	 sysinfo 생성 및 socketChannel 리스너 
	 */
	public void serverInit() {
		//생성순서 1번		
		
		SysInfo.threadPoolExecutor = new ThreadPoolExecutor(0, 20, 1L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		System.out.println("쓰레드 풀 생성");
		
		SysInfo.userDAO = new UserDAO();
		
		try {
			// 서버소켓 오픈
			// 2번생성
			SysInfo.serverSocketChannel = ServerSocketChannel.open();
			
			// 서버소켓 비동기식 - 블락킹 on //todo : selector 와 함께 false로 구현
			SysInfo.serverSocketChannel.configureBlocking(true);
			// 서버 정보 바인드
			SysInfo.serverSocketChannel.socket().bind(new InetSocketAddress(10001));				
		} catch (IOException e) {
			if (SysInfo.serverSocketChannel.isOpen())
				serverStop();			
			e.printStackTrace();
		}
		Runnable rn = new SocketListener();
		SysInfo.threadPoolExecutor.submit(rn);
	}

	public void receive(SocketChannel socketChannel,UserDTO userDTO) {
		
		Runnable rn = new MultiChatRunnable(socketChannel,userDTO);
		SysInfo.threadPoolExecutor.submit(rn);
	}

	public void serverStop() {
		ServerViewLoader.svc0.serverStopBt.setDisable(true);
		
		/** Dbconnection*/
		
		
		/* SocketChannel */
		if (!SysInfo.users.isEmpty()) {
			Set<MultiChatRunnable> k = SysInfo.users.keySet();			
			Stream<MultiChatRunnable> kStream = k.parallelStream();
			kStream.forEach(userSocket->{
				try {userSocket.socketChannel.close();} 
				catch (IOException e) {}
			});
			SysInfo.users.clear();
		}
		/* ServerSocketChannel */
		if (SysInfo.serverSocketChannel.isOpen()) {
			try {SysInfo.serverSocketChannel.close();} catch (IOException e) {}
		}
		/** ThreadPool **/
		if (!SysInfo.threadPoolExecutor.isShutdown()) {
			SysInfo.threadPoolExecutor.shutdown();
		}
		Platform.runLater(()->{
			ServerViewLoader.svc0.displayClear();
		});
	}
}
