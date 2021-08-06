package com.sen.server.service;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sen.server.util.SysInfo;

public class ServerSocketService {
	
	public void initServer() {
		SysInfo.threadPoolExecutor = 
				new ThreadPoolExecutor(0,20,1L,
								TimeUnit.SECONDS,
						new SynchronousQueue<Runnable>());
		
	}
}
