package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class MouseMotionEventEx extends Frame implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	public MouseMotionEventEx() {
		super("Move Test");
		addMouseMotionListener(this);
		setSize(400,300);
		setVisible(true);
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == this) 
			System.out.println("¿Ã∞«ππ∞Ì1");
			System.out.println("X = "+e.getX()+", Y = "+e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == this) {
			System.out.println("¿Ã∞«ππ∞Ì2");
			System.out.println("X = "+e.getX()+", Y = "+e.getY());
			}
	}


	public static void main(String[] args) {
		new MouseMotionEventEx();
	}
}
