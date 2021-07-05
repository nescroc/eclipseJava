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
		System.out.println("�̰Ƕǹ���");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("�̰ǹ����˰ڴ�");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		System.out.println("�̰͵������˰ڴ�");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("�����̰�");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("�ּ� ȭ");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("������ ȭ");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("�����߽��ϴ�.");
	}
	
	public static void main(String[] args) {
		new WindowEventEx2();
	}

}
