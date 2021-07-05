package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class WindowEventEx4 extends Frame {

	private static final long serialVersionUID = 1L;

	public WindowEventEx4() {
		super("EventEx4");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("¤Ã¤Ì¤Á");
				System.exit(0);
			
			}
		});
		setSize(400,300);
		setVisible(true);
	}
	static public void main(String args[]) {
		new WindowEventEx4();
	}

}
