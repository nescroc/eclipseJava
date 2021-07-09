package com.sen.awtpractice.grapchics;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicEx2 extends Frame {

	private static final long serialVersionUID = 1L;
	Button bt1, bt2, bt3;
	Panel north_p;
	Canvas can;
	private Color color;
	int x, y;

	public GraphicEx2() {
		north_p = new Panel();
		north_p.add(bt1 = new Button("Red"));
		north_p.add(bt2 = new Button("Blue"));
		north_p.add(bt3 = new Button("Green"));
		bt1.setBackground(Color.red);
		bt2.setBackground(Color.blue);
		bt3.setBackground(Color.green);
		bt1.setForeground(Color.white);
		bt2.setForeground(Color.white);
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("red");
				color = Color.RED;
			}
		});
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("blue");
				color = Color.BLUE;
			}
		});
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("green");
				color = Color.green;
			}
		});

		add(north_p, "North");
		add(can = new Canvas() {

			private static final long serialVersionUID = 1L;

			public void update(Graphics g) {
				paint(g);
			};

			public void paint(Graphics g) {
				g.setColor(color);
				g.fillOval(x - 2, y - 2, 4, 4);
			}

		});

		can.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				x = e.getX();
				y = e.getY();
				can.repaint();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(200, 200, 600, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicEx2();
	}

}
