package com.sen.awtpractice;

import java.awt.*;

public class ChoiceEx extends Frame {

	private static final long serialVersionUID = 1L;
	private Label la = new Label("����");
	private Choice co = new Choice();
	private Button bt = new Button("Ȯ��");
	
	public ChoiceEx() {
		super("Choice");
		setLayout(new GridLayout(3,1));
		add(la);
		for (int i = 1; i < 13; i++) {
			co.add(i+"��");
		}
		add(co);
		add(bt);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		//ChoiceEx ch = new ChoiceEx();
	}
}
