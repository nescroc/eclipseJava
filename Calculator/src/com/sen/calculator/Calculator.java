package com.sen.calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {

   private static final long serialVersionUID = 1L;
   private String[] sustr = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
   private Button[] subt = new Button[sustr.length];
   private String[] funstr = {"BackSpace", "CE", "C"};
   private Button[] funbt = new Button[funstr.length];
   private String[] opstr = {"+", "-", "*", "/"};
   private Button[] opbt = new Button[opstr.length];
   private Button equbt = new Button("=");
   private Label disp = new Label("0.", Label.RIGHT);
   /*----------------------------------------------------------------------*/
   private boolean first = true; //true 첨으로 누른다. false 첨이 아니다.
   private boolean jumcheck = false;// false 점을 누른적 없다. true 점을 누른적 있다.
   private char operator = '+';
   private boolean equcheck = false; // = 를 눌렀냠?
   private double result = 0; // 계산 결과
   
   public Calculator() {
      super("Calculator");
      buildGUI(); // 화면 구성
      setEvent(); // 이벤트 연결
   }
   
   private void buildGUI() {
      setBackground(Color.cyan);
      disp.setBackground(Color.white);
      add("North", new Label());
      add("South", new Label());
      add("West", new Label());
      add("East", new Label());
      
      Panel mainPanel = new Panel(new BorderLayout(3,3));
         disp.setFont(new Font("Arial", Font.BOLD, 15));
         mainPanel.add("North", disp);
         
         Panel cPanel = new Panel(new GridLayout(1,2,3,3));
            Panel leftPanel = new Panel(new GridLayout(4,3,3,3));
               for(int i=0; i<subt.length; i++) {
                  subt[i] = new Button(sustr[i]);
                  subt[i].setFont(new Font("Arial", Font.BOLD, 15));
                  leftPanel.add(subt[i]);
               }
            cPanel.add(leftPanel);
            
            Panel rightPanel = new Panel(new GridLayout(4,1,3,3));
               Panel p1 = new Panel(new GridLayout(1,3,3,3));
                  for(int i=0; i<funbt.length; i++) {
                     funbt[i] = new Button(funstr[i]);
                     funbt[i].setFont(new Font("Arial", Font.BOLD, 15));
                     p1.add(funbt[i]);
                  }
               rightPanel.add(p1);
               
               Panel p2 = new Panel(new GridLayout(1,2,3,3));
               Panel p3 = new Panel(new GridLayout(1,2,3,3));
                  for(int i=0; i<opbt.length; i++) {
                     opbt[i] = new Button(opstr[i]);
                     opbt[i].setFont(new Font("Arial", Font.BOLD, 15));
                     if(i < opbt.length/2) p2.add(opbt[i]);
                     else p3.add(opbt[i]);
                  }
               rightPanel.add(p2);
               rightPanel.add(p3);
               
               equbt.setFont(new Font("Arial", Font.BOLD, 15));
               rightPanel.add(equbt);
            cPanel.add(rightPanel);
         mainPanel.add("Center", cPanel);
      add("Center", mainPanel);
      
      pack();
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
      setVisible(true);
   }
   
   private void setEvent() {
      for(int i=0; i<subt.length; i++)
         subt[i].addActionListener(this);
      for(int i=0; i<funbt.length; i++)
         funbt[i].addActionListener(this);
      for(int i=0; i<opbt.length; i++)
         opbt[i].addActionListener(this);
      equbt.addActionListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      for(int i=0; i<subt.length-2; i++) {
         if(e.getSource() == subt[i]) {
            if(first) { // 처음으로 누른다.
               if(subt[i].getLabel().equals("0")) return;
               disp.setText(subt[i].getLabel() + ".");
               first = false;
               equcheck = false;
            }else {// 처음이 아니다.
               String imsi = disp.getText();
               if(jumcheck) {// 점을 누른적 있다.
                  disp.setText(imsi + subt[i].getLabel());
               }else { // 점을 누른적 없다.
                  imsi = imsi.substring(0, imsi.length()-1);
                  disp.setText(imsi + subt[i].getLabel() + ".");
               }
            }
            return;
         }
      }
      if(e.getSource() == subt[subt.length-2]) {// +/-
         if(disp.getText().equals("0.")) return;
         char signal = disp.getText().charAt(0);
         if(signal == '-') {
            disp.setText(disp.getText().substring(1));
         }else {
            disp.setText("-" + disp.getText());
         }
         return;
      }
      if(e.getSource() == subt[subt.length-1]) {// .
         first = false;
         jumcheck = true;
         equcheck = false;
         return;
      }
      if(e.getSource() == funbt[0]) {// BackSpace
         String imsi = disp.getText();
         if(imsi.equals("0.")) return; 
         if(imsi.length() == 2) { // 3. 2. 이런경우
            disp.setText("0.");
            first = true; jumcheck = false; return;
         }
         if(imsi.length() == 3 && imsi.charAt(0) == '-') {// -3. 이런경우
            disp.setText("0.");
            first = true; jumcheck = false; return;
         }
         if(imsi.charAt(0)=='-' && imsi.substring(1, imsi.length()-1).equals("0.")) {
            // -0.6 이런경우
            disp.setText("0.");
            first = true; jumcheck = false; return;
         }
         if(imsi.charAt(imsi.length()-1) != '.') { //마지막이 점이 아니냐?
            disp.setText(imsi.substring(0, imsi.length()-1));
         }else {
            disp.setText(imsi.substring(0, imsi.length()-2) + ".");
            jumcheck = false;
         }
         return;
      }
      if(e.getSource() == funbt[1]) {// CE
         disp.setText("0.");
         first = true;
         jumcheck = false;
         return;
      }
      if(e.getSource() == funbt[2]) {// C
         disp.setText("0.");
         first = true;
         jumcheck = false;
         operator = '+';
         equcheck = false;
         result = 0;
         return;
      }
      for(int i=0; i<opbt.length; i++) { // + - * /
         if(e.getSource() == opbt[i]) {
            calc(); // 계산 처리
            operator = opbt[i].getLabel().charAt(0);
            first = true;
            jumcheck = false;
         }
      }
      if(e.getSource() == equbt) {
         if(equcheck) return;
         calc();
         first = true;
         jumcheck = false;
         operator = '+';
         equcheck = true;
         result = 0;
      }
   }
   
   private void calc() {//계산처리를 해주는 메서드
      double value = Double.parseDouble(disp.getText());
      switch(operator) {
      case '+' : result = result + value; break;
      case '-' : result = result - value; break;
      case '*' : result = result * value; break;
      case '/' : result = result / value; break;
      }
      double test = result - (int)result;
      if(test > 0) {
         disp.setText(String.valueOf(result));
      }else {
         disp.setText(String.valueOf((int)result) + ".");
      }
   }
   
   public static void main(String[] args) {
      new Calculator();
   }
}