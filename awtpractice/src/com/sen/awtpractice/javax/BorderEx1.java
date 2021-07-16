package com.sen.awtpractice.javax;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderEx1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton[] jb = new JButton[6];

	public BorderEx1() {
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(3, 2, 5, 5));
		for (int i = 0; i < 6; i++) {
			jb[i] = new JButton(i + "¹ø ¹öÆ°");
			con.add(jb[i]);
		}
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderEx1();

	}
}
