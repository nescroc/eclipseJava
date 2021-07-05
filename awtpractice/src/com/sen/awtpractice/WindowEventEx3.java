package com.sen.awtpractice;

import java.awt.Frame;
import java.awt.event.*;

public class WindowEventEx3 extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowEventEx3() {
		super("EventEx3");
		addWindowListener(new WinEventEx());
		setSize(300, 200);
		setVisible(true);
	}

	class WinEventEx extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		};
	}

	public static void main(String[] args) {
		new WindowEventEx3();

	}

}
