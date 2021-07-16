package com.sen.awtpractice.graphics;

import java.awt.*;
import java.awt.event.*;

public class GraphicEx3 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Image im;
	private Button bt = new Button("확대");
	private Button bt1 = new Button("축소");
	private int w = 160;
	private int h = 240;

	public GraphicEx3() {
		super("Graph Test");
		im = Toolkit.getDefaultToolkit().getImage("C:\\pmProject\\eclipseWorkspace\\awtpractice\\src\\com\\sen\\awtpractice\\grapchics\\image\\girs.jpg");
		//im = Toolkit.getDefaultToolkit().getImage("../graphics/image1/girs.jpg");
		setLayout(new BorderLayout());
		add("North", new Label("이미지 파일", Label.CENTER));
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(bt);
		p.add(bt1);
		bt1.setEnabled(false);
		bt.addActionListener(this);
		bt1.addActionListener(this);
		add("South", p);
		setSize(400, 550);
		setVisible(true);

	}

	public void paint(Graphics g) {
		g.drawImage(im, 40, 50, w, h, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {// 확대
			bt.setEnabled(false);
			bt1.setEnabled(true);
			w = 320;
			h = 480;
			repaint();
		}
		if (e.getSource() == bt1) {// 확대
			bt1.setEnabled(false);
			bt.setEnabled(true);
			w = 160;
			h = 240;
			repaint();
		}
	}

	public static void main(String[] args) {
		new GraphicEx3();
	}

}
