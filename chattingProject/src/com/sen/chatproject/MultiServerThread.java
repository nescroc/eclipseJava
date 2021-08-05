package src.com.sen.chatproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}
	
	@Override
	public synchronized void  run() {
		boolean isStop = false;
		try {
			socket = ms.getSocket();
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			String message = null;
			while (!isStop) {
				message = (String)ois.readObject();
				String[] str = message.split("#");
				if (str[1].equals("exit")) {
					broadCasting(message);					
				}else {
					broadCasting(message);
					isStop = true;
				}
			}
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress()+
					"정상적으로 종료하셨습니다.");
			System.out.println("list size : "+ms.getList().size());
		} catch (Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress()+
					"비정상적으로 종료하셨습니다.");
			System.out.println("list size : "+ms.getList().size());
		}
	}

	private void broadCasting(String message) throws IOException{
		oos.writeObject(message);
	}

}
