package com.sen.awtpractice;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx4 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Button[] bt = new Button[4];
	private Panel[] pp = new Panel[4];
	private Color[] cc = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
	private CardLayout card = new CardLayout();
	private Panel pptop;

	public ActionEventEx4() {
		super("ActionEventEx4");
		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(1, 4));
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new Button(i + 1 + "¹ø ¹öÆ°");
			bt[i].addActionListener(this);
			p.add(bt[i]);
		}
		add("North", p);
		pptop = new Panel(card);
		for (int i = 0; i < bt.length; i++) {
			pp[i] = new Panel();
			pp[i].setBackground(cc[i]);
			pptop.add("" + i, pp[i]);
		}
		add("Center", pptop);
		card.show(pptop, "0");
		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource() == bt[i]) {
				card.show(pptop, "" + i);
			}

		}
	}

	public static void main(String[] args) {
		new ActionEventEx4();
	}

}
