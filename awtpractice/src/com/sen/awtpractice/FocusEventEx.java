package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class FocusEventEx extends Frame implements FocusListener {

	private static final long serialVersionUID = 1L;
	private TextField tf[] = new TextField[3];

	FocusEventEx() {
		super("FocusEx");
		setForm();
		setSize(300, 200);
		setVisible(true);

	}

	public void setForm() {
		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(3,1));
			p.add(new Label("�̸�"));
			p.add(new Label("��ȭ"));
			p.add(new Label("�ּ�"));
		add("West",p);
		Panel pp = new Panel(new GridLayout(3,1));
		for (int i = 0; i < tf.length; i++) {
			tf[i] =  new TextField();
			pp.add(tf[i]);
			tf[i].addFocusListener(this);
		}
		add("Center",pp);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource()==tf[1]) {
			if (tf[0].getText().trim().length()==0) {
				tf[0].setText("");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ee) {}
				tf[0].requestFocus();
			}
		}
		if (e.getSource()== tf[2]) {
			if (tf[1].getText().trim().length()==0) {
				tf[1].setText("");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ee) {}
				tf[1].requestFocus();
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {}

	public static void main(String[] args) {
			new FocusEventEx();		
	}

}
