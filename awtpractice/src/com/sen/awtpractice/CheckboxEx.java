package com.sen.awtpractice;

import java.awt.*;

public class CheckboxEx extends Frame {

	private static final long serialVersionUID = 1L;
	private Label lb = new Label("�����ϴ� ������ ?");
	private Checkbox[] cb = { new Checkbox("�ٳ���"),
			new Checkbox("����", true), new Checkbox("���ξ���") };
	private Button bt = new Button("Ȯ��");

	public CheckboxEx() {
		super("Checkbox");
		setLayout(new GridLayout(5,1));
		add(lb);
		for (int i = 0; i < cb.length; i++) {
			add(cb[i]);
		}
		add(bt);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		//CheckboxEx cs = new CheckboxEx();
	}
}
