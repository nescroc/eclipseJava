package com.sen.awtpractice.grapchics;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GraphicEx1 extends Frame implements
			MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private int x;private int y;
	private int w;private int h;
	
	public GraphicEx1() {
		super("GraphicEx");
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(500,400);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
	
			g.drawOval(x, y, w-x, h-y);
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource()==this) {
			w = e.getX(); h = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource()==this) {
			x = e.getX(); y= e.getY();
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource()==this) {
			w = e.getX(); h= e.getY();
			repaint();
		}
	}

	public static void main(String[] args) {
		new GraphicEx1();
	}
}
