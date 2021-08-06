package com.sen.client.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import com.sen.client.util.Config;


public class SocektService {
	// �������ӽ���

	public void socketInit() {		
		  try { Config.socketChannel = SocketChannel.open();
		  Config.socketChannel.configureBlocking(true);
		  Config.socketChannel.connect(new InetSocketAddress("localhost", 5050)); }
		  catch (Exception e) { if (Config.socketChannel.isOpen()) socketDestory(); }
		}
	// ������������
		private void socketDestory() {
			try {
				if (Config.socketChannel != null && Config.socketChannel.isOpen())
					Config.socketChannel.close();
			} catch (IOException ioe) {
			}
		}
	// �߽�
	  public void sender(String message) {
	    
	    Thread thread = new Thread() {
	      
	        @Override
	        public void run() {
	            try {
	                
	                Charset charset = Charset.forName("UTF-8");
	                
	                ByteBuffer byteBuffer = charset.encode(message);
	                
	                Config.socketChannel.write(byteBuffer);
	                
	            } catch(Exception e) {
	            	socketDestory();
	            }
	        }
	    };
	    thread.start();
	  }
	  //����
	public void receiver() {
		while (true) {
			try {

				ByteBuffer byteBuffer = 
						ByteBuffer.allocate(Config.bufferSize);
				
				int byteCount = 
						Config.socketChannel.read(byteBuffer);
				
				if (byteCount == -1) 
					throw new IOException();
				
				byteBuffer.flip();
				Charset charset = Charset.forName("UTF-8");
				
				String message = 
						charset.decode(byteBuffer).toString();
				
				TextWriter.write(message);
			} catch (Exception e) {				
				socketDestory();
			}

		}
	}

	
}
