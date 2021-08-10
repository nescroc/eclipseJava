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
							
				//3������				
				SysInfo.users = new ConcurrentHashMap<MultiChatRunnable, UserDTO>();
				while (true) {
					try {
						SocketChannel socketChannel = SysInfo.serverSocketChannel.accept();
						String ip = socketChannel.getRemoteAddress().toString();						/*
						 * ������Ʈ todo if(QueryBase.selectBlacklist(ip)) { socketChannel.close();
						 * continue; }
						 */
						System.out.println(ip);
						//SysInfo.users.put(socketChannel, ip);
						UserDTO userDTO = new UserDTO();
						userDTO.setIp(ip);
						
						receive(socketChannel, userDTO);
						ServerViewLoader.svc0.updateStatus();
						System.out.println("���� ����");
					} catch (IOException e) {
						if (SysInfo.serverSocketChannel.isOpen()) 
									serverStop(); break;
						
					}
				}
			
		}

	}

	/*
	 sysinfo ���� �� socketChannel ������ 
	 */
	public void serverInit() {
		//�������� 1��		
		
		SysInfo.threadPoolExecutor = new ThreadPoolExecutor(0, 20, 1L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		System.out.println("������ Ǯ ����");
		
		SysInfo.userDAO = new UserDAO();
		
		try {
			// �������� ����
			// 2������
			SysInfo.serverSocketChannel = ServerSocketChannel.open();
			
			// �������� �񵿱�� - ���ŷ on //todo : selector �� �Բ� false�� ����
			SysInfo.serverSocketChannel.configureBlocking(true);
			// ���� ���� ���ε�
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
