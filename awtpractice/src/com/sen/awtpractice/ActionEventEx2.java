package com.sen.awtpractice;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.*;

public class ActionEventEx2 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Button bt = new Button("»Æ¿Œ");

	ActionEventEx2() {
		super("ActionEventEx2");
		bt.addActionListener(this);
		setLayout(new FlowLayout());
		add(bt);
		setSize(400, 300);
		setVisible(true);

	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new ActionEventEx2();
	}
}
