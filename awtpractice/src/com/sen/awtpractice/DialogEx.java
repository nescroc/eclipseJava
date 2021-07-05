package com.sen.awtpractice;

import java.awt.*;


public class DialogEx extends Frame {
	
	private static final long serialVersionUID = 1L;
	private Dialog d = new Dialog(this,"��ȸ����",false);
	private Label dlb = new Label("�̸��� �ֹι�ȣ�� ��й�ȣ ã��");
	private Label dlb1 = new Label("�̸� : ",Label.RIGHT);
	private Label dlb2 = new Label("�ֹι�ȣ",Label.RIGHT);
	private Label dlb3 = new Label("-",Label.CENTER);
	private TextField dtf = new TextField(20);
	private TextField dtf1 = new TextField(6);
	private TextField dtf2 = new TextField(7);
	private Button dbt = new Button("ã��");
	private Button dbt1 = new Button("���");
	public DialogEx() {
		super("DialogEx");
		setDialog();
		setSize(300,200);
		setVisible(true);
		d.setVisible(true);
	}

	
	private void setDialog() {
		d.setLayout(new BorderLayout());
		d.add("North",dlb);
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new GridLayout(2,1));
		p2.add(dlb1);
		p2.add(dlb2);
		p1.add("West",p2);
		Panel p3 = new Panel(new GridLayout(2,1));
		Panel tfPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
		tfPanel.add(dtf);
		p3.add(tfPanel);
		Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p4.add(dtf1);
		p4.add(dlb3);
		p4.add(dtf2);
		p3.add(p4);
		p1.add("Center",p3);
		d.add("Center",p1);
		Panel p = new Panel(new FlowLayout());
		p.add(dbt);
		p.add(dbt1);
		d.add("South",p);
		d.setSize(260,130);
		d.setResizable(false);
	}


	public static void main(String[] args) {
		//DialogEx d = new DialogEx();
	}

}
