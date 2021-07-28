package com.sen.chatexample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {

	private ArrayList<MultiServerThread> list;
	private Socket socket;
	public MultiServer() throws IOException{
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(5000);
	}

}