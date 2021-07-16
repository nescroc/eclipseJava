package com.sen.awtpractice.javax;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class JTabbedPaneEx extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private  String sysPath = "C:\\Users\\nes05\\OneDrive\\���� ȭ��\\����\\����pdf\\image(18)";
	private String[] path = {"\\ico03.JPG","\\ico04.JPG"}; 
	private ImageIcon icon1 = new ImageIcon(sysPath+path[0]);
	private ImageIcon icon2 = new ImageIcon(sysPath+path[1]);
	private JLabel jlb = new JLabel("��",icon1,JLabel.CENTER);
	private JButton jbt = new JButton("��ư",icon1);
	private JTabbedPane jtp = new JTabbedPane(SwingConstants.TOP);
	
	public JTabbedPaneEx() {
		super("JTabbedPaneEx");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		jtp.addTab("��", icon2,jlb);
		jtp.addTab("��", icon2,jbt);
		con.add("Center",jtp);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTabbedPaneEx();
	}
}
