package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class MouseEventEx extends Frame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Button bt = new Button("Ȯ��");
	private Button bt1 = new Button("���");

	public MouseEventEx() {
		super("Mouse Test");
		setLayout(new FlowLayout());
		add(bt);
		add(bt1);
		setEvent();
		setSize(400, 300);
		setVisible(true);
	}

	public void setEvent() {
		bt.addMouseListener(this);
		bt1.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == bt)
			System.out.println("Ȯ�ι�ư");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == bt1)
			System.out.println("��ҹ�ư�� ������");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == bt1)
			System.out.println("��ҹ�ư�� ������ ����...");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == bt || e.getSource() == bt1)
			System.out.println("���콺�� ��ư���� ������...");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == bt || e.getSource() == bt1)
			System.out.println("���콺�� ��ư���� �����Դ�...");

	}

	public static void main(String[] args) {
		new MouseEventEx();
	}

}
