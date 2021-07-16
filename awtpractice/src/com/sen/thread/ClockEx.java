package com.sen.thread;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class ClockEx extends Frame implements ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button bt = new Button("시작");

	public ClockEx() {
		super("시계");
		setLayout(new BorderLayout());
		add("South", bt);
		bt.addActionListener(this);
		setSize(600, 200);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}
		});
	}

	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			bt.setEnabled(false);
			Thread tt = new Thread(this);
			tt.start();
		}
	}

	public void paint(Graphics g) {
		Calendar ca = Calendar.getInstance();
		java.util.Date d = ca.getTime();
		g.setFont(new Font("굴림체", Font.BOLD, 30));
		g.drawString(d.toString(), 50, 100);
	}

	public static void main(String[] args) {
		new ClockEx();
	}
}
