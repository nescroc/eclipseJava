package com.cms.controller;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cms.vo.Customer;

public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener{
   
   /* ------------------------- ȭ����� ������Ʈ ----------------------------------*/
   private static final long serialVersionUID = 1L;
   private TextField nametf = new TextField(20);
   
   private TextField jumin1tf = new TextField(7);
   private TextField jumin2tf = new TextField(8);
   
   private String[] tstr = {"010", "011", "016", "017", "018", "019"};
   private Choice telch = new Choice();
   private TextField tel1tf = new TextField(4);
   private TextField tel2tf = new TextField(4);
   
   private CheckboxGroup cg = new CheckboxGroup();
      private Checkbox man = new Checkbox("����", cg, true);
      private Checkbox woman = new Checkbox("����", false, cg);
   
   private String[] hstr = {"��ȭ", "����", "����", "����", "����"};
   private Checkbox[] hobby = new Checkbox[hstr.length];

   private Button addbt = new Button("���");
   private Button dispbt = new Button("�м�");
   private Button updatebt = new Button("����");
   private Button delbt = new Button("����");
   private Button initbt = new Button("�Է¸��");
   
   private List listli = new List();
   private TextArea infota = new TextArea();
   
   /* ------------------------- �޴����� ������Ʈ ----------------------------------*/
   private MenuBar mb = new MenuBar();
   private Menu mfile = new Menu("File");
      private MenuItem mfnew = new MenuItem("������");
      private MenuItem mfopen = new MenuItem("�ҷ�����");
      private MenuItem mfsave = new MenuItem("�����ϱ�");
      private MenuItem mfsaveas = new MenuItem("���̸����������ϱ�");
      private MenuItem mfexit = new MenuItem("����");
   private Menu mhelp = new Menu("Help");
      private MenuItem mhver = new MenuItem("��������");
   
   /* ------------------------- ���̾˷αװ��� ������Ʈ ----------------------------------*/
   private Dialog dialog = new Dialog(this, "��������", true);
   private Label dlabel = new Label("Customer Manager V1.0", Label.CENTER);
   private Button dbutton = new Button("Check");
      
   /* ------------------------- ��Ÿ���� ������Ʈ ----------------------------------*/
   private java.util.List<Customer> data = new java.util.ArrayList<Customer>();
   
   public CustomerManager(){
      super("CustomerManager");
      setMenu();      //   �޴� ����
      setDialog();   //   ���̾˷α� ����
      buildGUI();      //   ȭ�� ����
      setEvent();      //    �̺�Ʈ ����
   }

   private void setEvent() {//�̺�Ʈ ����
      addbt.addActionListener(this);
      tel1tf.addActionListener(this);
      telch.addItemListener(this);
      jumin2tf.addKeyListener(this);
      jumin1tf.addKeyListener(this);
      nametf.addActionListener(this);
      mfexit.addActionListener(this);
      dbutton.addActionListener(this);
      mhver.addActionListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == tel1tf) {
         tel2tf.requestFocus(); return;
      }
      if(e.getSource() == nametf) {
         jumin1tf.requestFocus(); return;
      }
      if(e.getSource() == mfexit) {
         System.exit(0);
      }
      if(e.getSource() == mhver) {
         dialog.setVisible(true); return;
      }
      if(e.getSource() == dbutton) {
         dialog.setVisible(false); return;
      }
      if(e.getSource() == addbt) {//��Ϲ�ư
         String name = nametf.getText().trim();
         String jumin = jumin1tf.getText().trim() + jumin2tf.getText().trim();
         String tel = telch.getSelectedItem() + "-" + tel1tf.getText().trim() + "-" + tel2tf.getText().trim();
         boolean gender = man.getState();
         StringBuffer myhobby = new StringBuffer();
         for(int i=0; i<hobby.length; i++) {
            if(hobby[i].getState()) {
               myhobby.append(hobby[i].getLabel());
               myhobby.append("-");
            }
         }
         if(myhobby.length() == 0) {
            myhobby.append("����");
         }else {
            myhobby.substring(0, myhobby.length()-1);
         }
         
         Customer myCustomer = new Customer(name, jumin, tel, gender, myhobby.toString());
         
         data.add(myCustomer);
         listli.add(myCustomer.toString());
         infota.setText("\n\t���������� �����Ͱ� ��ϵǾ����ϴ�.");
         
      }//end ���
   }

   @Override
   public void itemStateChanged(ItemEvent e) {
      if(e.getSource() == telch) {
         tel1tf.requestFocus(); return;
      }
   }
   
   public void setButton(boolean state) {
      addbt.setEnabled(state);
      dispbt.setEnabled(!state);
      updatebt.setEnabled(!state);
      delbt.setEnabled(!state);
      initbt.setEnabled(!state);
   }
   
   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getSource() == jumin1tf) {
         if(jumin1tf.getText().trim().length() == 6) {
            jumin2tf.requestFocus(); return;
         }
      }
      if(e.getSource() == jumin2tf) {
         if(jumin2tf.getText().trim().length() == 7) {
            telch.requestFocus(); return;
         }
      }
   }
   
   @Override
   public void keyPressed(KeyEvent e) { }

   @Override
   public void keyTyped(KeyEvent e) { }
   
   private void setMenu() {//�޴�����
      setMenuBar(mb);
      mb.add(mfile);
         mfile.add(mfnew);
         mfile.addSeparator();
         mfile.add(mfopen);
         mfile.add(mfsave);
         mfile.add(mfsaveas);
         mfile.addSeparator();
         mfile.add(mfexit);
      mb.add(mhelp);
         mhelp.add(mhver);
   }
   
   private void setDialog() {
      dialog.setLayout(new BorderLayout(3,3));
      dlabel.setFont(new Font("Sans-serif", Font.BOLD, 25));
      dbutton.setFont(new Font("Sans-serif", Font.BOLD, 25));
      dialog.add("Center", dlabel);
      dialog.add("South", dbutton);
      dialog.setSize(335, 130);   
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = dialog.getSize();
      dialog.setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
   }
   
   private void buildGUI() {//ȭ�鱸��
      setBackground(Color.CYAN);
      add("North", new Label());
      add("West", new Label());
      add("East", new Label());
      add("South", new Label());
      
      Panel mainPanel = new Panel(new BorderLayout(5,5));
         Panel southPanel = new Panel(new BorderLayout(5,5));
            southPanel.add("North", new Label("�� �� �� �� �� �� �� ��", Label.CENTER));
            southPanel.add("Center", infota);
         mainPanel.add("South", southPanel);
         
         Panel eastPanel = new Panel(new BorderLayout(5,5));
            eastPanel.add("North", new Label("�� ü �� ��", Label.CENTER));
            eastPanel.add("Center", listli);
         mainPanel.add("East", eastPanel);
         
         Panel centerPanel = new Panel(new BorderLayout(5,5));
            centerPanel.add("North", new Label("�� �� �� �� �� ��", Label.CENTER));
            
            Panel cwPanel = new Panel(new GridLayout(5,1,5,5));
               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
               cwPanel.add(new Label("�ֹι�ȣ : ", Label.RIGHT));
               cwPanel.add(new Label("��ȭ��ȣ : ", Label.RIGHT));
               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
               cwPanel.add(new Label("��        �� : ", Label.RIGHT));
            centerPanel.add("West", cwPanel);
            
            centerPanel.add("East", new Label());
            
            Panel csPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
               csPanel.add(addbt);
               csPanel.add(dispbt);
               csPanel.add(updatebt);
               csPanel.add(delbt);
               csPanel.add(initbt);
            centerPanel.add("South", csPanel);
            
            Panel ccPanel = new Panel(new GridLayout(5,1,5,5));
               Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p1.add(nametf);
               ccPanel.add(p1);
               
               Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p2.add(jumin1tf);
                  p2.add(new Label("-", Label.CENTER));
                  p2.add(jumin2tf);
               ccPanel.add(p2);
               
               Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(String telStr : tstr) telch.add(telStr);
                  p3.add(telch);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tel1tf);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tel2tf);
               ccPanel.add(p3);
               
               Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p4.add(man);
                  p4.add(woman);
               ccPanel.add(p4);
               
               Panel p5 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(int i=0; i<hobby.length; i++) {
                     hobby[i] = new Checkbox(hstr[i]);
                     p5.add(hobby[i]);
                  }
                  p5.add(new Label());// �ȳ����� ������ ������ �Ⱥ���.
               ccPanel.add(p5);
            centerPanel.add("Center", ccPanel);
         mainPanel.add("Center", centerPanel);
      add("Center", mainPanel);
      
      pack();
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
      
      setButton(true);
      nametf.requestFocus();
      
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new CustomerManager();
   }



}