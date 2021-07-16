package com.sen.awtpractice.javax;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameEx extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrameEx() {
		super("JFrame Å×½ºÆ®");
		JButton bt1 = new JButton("Hello Swing North");
		JButton bt2 = new JButton("Hello Swing Center");
		Container con = getContentPane();
		con.add("North",bt1); add(bt2);
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JFrameEx();
	}

}
