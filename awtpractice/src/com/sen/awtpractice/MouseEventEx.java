package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class MouseEventEx extends Frame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Button bt = new Button("확인");
	private Button bt1 = new Button("취소");

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
			System.out.println("확인버튼");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == bt1)
			System.out.println("취소버튼을 눌렀당");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == bt1)
			System.out.println("취소버튼을 눌렀다 땟당...");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == bt || e.getSource() == bt1)
			System.out.println("마우스가 버튼위에 있지롱...");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == bt || e.getSource() == bt1)
			System.out.println("마우스가 버튼위에 내려왔당...");

	}

	public static void main(String[] args) {
		new MouseEventEx();
	}

}
