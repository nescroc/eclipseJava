package com.sen.awtpractice;

import java.awt.*;

class CheckboxGroupEx extends Frame {

	private static final long serialVersionUID = 1L;
	GridLayout gl = new GridLayout(4, 1);
	Label la = new Label("������ ? ");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox man = new Checkbox("����", cg, true);
	Checkbox woman = new Checkbox("����", cg, false);
	Button bt = new Button("Ȯ��");

	public CheckboxGroupEx() {
		super("CheckboxGroup");
		setLayout(gl);
		add(la);
		add(man);
		add(woman);
		add(bt);
		pack();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		//CheckboxGroupEx cg = new CheckboxGroupEx();
	}

}
