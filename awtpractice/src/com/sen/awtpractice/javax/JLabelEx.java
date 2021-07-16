package com.sen.awtpractice.javax;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private String path = "C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업"+
					"\\수업pdf\\image(18)\\ico01.JPG";
	private Icon icon = new ImageIcon(path);
	private JLabel jlb1 = new JLabel(icon);
	private JLabel jlb2 = new JLabel("Test2",JLabel.CENTER);
	private JLabel jlb3 = new JLabel("Test3",icon,SwingConstants.RIGHT);
	
	public JLabelEx() {
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(3, 1));
		con.add(jlb1);
		con.add(jlb2);
		jlb2.setIcon(icon);
		con.add(jlb3);
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JLabelEx();
	}
	
}
