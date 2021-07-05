package com.sen.awtpractice;

import java.awt.*;


public class MenuEx extends Frame {
	
	private static final long serialVersionUID = 1L;
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("����");
	private Menu edit = new Menu("����");
	private Menu view = new Menu("����");
	private Menu help = new Menu("����");
	private MenuItem fnew = new MenuItem("������");
	private MenuItem fopen = new MenuItem("���� ����");
	private MenuItem fsave= new MenuItem("���� ����");
	private MenuItem fsaveas = new MenuItem("�ٸ��̸����� ����");
	private MenuItem fexit = new MenuItem("������");
	private Menu ecolor = new Menu("����");
	private Menu esize = new Menu("ũ��");
	private CheckboxMenuItem ecred = 
				new CheckboxMenuItem("����");
	private CheckboxMenuItem ecgreen = 
				new CheckboxMenuItem("�ʷ�");
	private CheckboxMenuItem ecblue = 
			new CheckboxMenuItem("�Ķ�");
	private CheckboxMenuItem es10 = new CheckboxMenuItem("10");
	private CheckboxMenuItem es20 = new CheckboxMenuItem("20");
	private CheckboxMenuItem es30 = new CheckboxMenuItem("30");
	public MenuEx() {
		super("Menu Test");
		setMenuBar(mb);
		mb.add(file); mb.add(edit);
		mb.add(view); mb.add(help);
		ecolor.add(ecred);
		ecolor.add(ecgreen);ecolor.add(ecblue);
		esize.add(es10); esize.add(es20);esize.add(es30);
		edit.add(ecolor); edit.addSeparator();
		edit.add(esize);
		file.add(fnew); file.addSeparator();
		file.add(fopen); file.add(fsave);
		file.add(fsaveas);file.addSeparator();
		file.add(fexit);
		setLayout(new BorderLayout());
		add("North",new Label("�����ϼ̽��ϴ�....",Label.CENTER));
		add("Center",new TextArea());
		Panel p = new Panel(new GridLayout(1,2));
		p.add(new Button("Ȯ��"));
		p.add(new Button("���"));
		add("South",p);
		setSize(300,200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
	 //MenuEx mt = new MenuEx();
	}

}
