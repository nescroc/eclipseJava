package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx1 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private TextField tf = new TextField(10);

	ActionEventEx1() {
		super("ActionEventEx1");
		setLayout(new FlowLayout());
		add(tf);
		setSize(500, 400);
		tf.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			String imsi = tf.getText();
			System.out.println("¸Þ½ÃÁö : " + imsi);
			tf.setText("");
		}
	}

	public static void main(String[] args) {
		new ActionEventEx1();
	}

}
