package com.sen.awtpractice;

import java.awt.*;

public class ListEx extends Frame {

	private static final long serialVersionUID = 1L;
	private Label lb = new Label("�ο� ���");
	private List li = new List(4, true);
	private Button bt = new Button("Ȯ��");
	private String[] name;

	public ListEx(String[] a) {
		super("List Test");
		name = a;
		setLayout(new BorderLayout());
		for (int i = 0; i < name.length; i++) {
			li.add(name[i]);		
		}
		add("North",lb);
		add("South",bt);
		add("Center",li);
		li.setFont(new Font("����ü",Font.BOLD,30));
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		//ListEx ls = new ListEx(args);
	}

}
