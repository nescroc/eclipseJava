package com.sen.awtpractice.javax;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JButtonEx extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//intel core x 10900, 32G, 3080ti, 1t ssd , 3t hd, 1000w
	//7 5700 octo 3.8ghz 16g ram 3070ti 8g ssd 500 1t h 800w
	private String sysPath = "C:\\Users\\nes05\\OneDrive\\바탕 화면\\수업\\수업pdf\\image(18)";
	private String[] path =  {"\\ico01.JPG","\\ico02.JPG","\\ico03.JPG","\\ico04.JPG"};
	private Icon icon1 = new ImageIcon(sysPath+path[0]);
	private Icon icon2 = new ImageIcon(sysPath+path[1]);
	private Icon icon3 = new ImageIcon(sysPath+path[2]);
	private Icon icon4 = new ImageIcon(sysPath+path[3]);
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	
	public JButtonEx(){
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
			for (int i = 0; i < jb.length; i++) {
				jb[i] = new JRadioButton(i+1+"번 버튼",icon1);
				con.add(jb[i]);
				jb[i].setMnemonic(i+49);
				jb[i].setRolloverIcon(icon2);
				jb[i].setPressedIcon(icon3);
				jb[i].setSelectedIcon(icon4);
				bg.add(jb[i]);
			}
			pack();
			setVisible(true);			
	}
	public static void main(String[] args) {
		
		new JButtonEx();
	}
	
}
