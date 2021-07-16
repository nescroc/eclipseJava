package com.sen.awtpractice.javax;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea ta = new JTextArea(5,10);
	private JScrollPane js  = new JScrollPane(ta);
	
	public JTextAreaEx() {
		super("Test");
		JPanel jp = (JPanel)this.getContentPane();
		jp.setLayout(new BorderLayout());
		jp.add("Center",js);
		setSize(new Dimension(300,200));
		setVisible(true);
	}
	public static void main(String[] args) {
		new JTextAreaEx();
	}
}
