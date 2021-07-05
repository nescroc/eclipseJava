package com.sen.awtpractice;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventEx2 extends Frame 
		implements WindowListener{
	
	private static final long serialVersionUID = 1L;
	
	public WindowEventEx2() {
		super("EventEx2");
		addWindowListener(this);
		setSize(300,200);
		setVisible(true);
	}
	

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("이건또뭐지");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("이건뭔지알겠다");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		System.out.println("이것도뭔지알겠다");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("뭐지이건");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("최소 화");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("아이콘 화");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("시작했습니다.");
	}
	
	public static void main(String[] args) {
		new WindowEventEx2();
	}

}
