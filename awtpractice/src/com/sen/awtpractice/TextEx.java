package com.sen.awtpractice;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class TextEx extends Frame {

	private static final long serialVersionUID = 1L;
	private TextField tf = new TextField("���� : ");
	private TextArea ta = new TextArea("�޸�",5,10);
	private Button bt = new Button("Ȯ��");
	private Label la = new Label("����");
	public TextEx() {
		super("TextExField");
		setLayout(new BorderLayout());
		add("North",tf);
		add("South",bt);
		add("Center",ta);
		add("West",la);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String args[] ){
		//TextEx te = new TextEx();
		
	}
}
