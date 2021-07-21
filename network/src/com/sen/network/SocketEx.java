package com.sen.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketEx {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost",3000);
		s.close();
	}

}
