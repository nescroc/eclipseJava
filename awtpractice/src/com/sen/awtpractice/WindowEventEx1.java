package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

class WinEvent extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
public class WindowEventEx1 extends Frame{
	private static final long serialVersionUID = 1L;
	
	public WindowEventEx1() {
		super("EventEx1");
		WinEvent we = new WinEvent();
		addWindowListener(we);
		setSize(300,200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new WindowEventEx1();
	}
	
}