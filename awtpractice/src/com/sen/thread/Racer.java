package com.sen.thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Racer extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int pos;
	private static int rank = 1;
	private int step =600;
	private Image image =null;
	public Racer(String name) {
		this.name =name;
		image = 
		Toolkit.getDefaultToolkit().getImage("./horse.gif");
	}
	public String return_name(){
		return name;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, getSize().height/2, 
				getSize().width, getSize().height/2);
		g.drawImage(image, pos*getSize().width/step, 0, 25, getSize().height,this);
		
	}
	@Override
	public void run() {
		for (int i = 0; i <= step; i+=((int)(Math.random()*10)+1)) {
			try {
				Thread.sleep(150);
			} catch (Exception e) {}
			pos = i;
			repaint();
		}
		System.out.println(rank++ +"�� �� �̸� : "+name);
	}

}
