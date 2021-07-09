package com.cms.controller;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.cms.vo.Customer;

public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener{
   
   /* ------------------------- 화면관련 컴포넌트 ----------------------------------*/
   private static final long serialVersionUID = 1L;
   private TextField nametf = new TextField(20);
   
   private TextField jumin1tf = new TextField(7);
   private TextField jumin2tf = new TextField(8);
   
   private String[] tstr = {"010", "011", "016", "017", "018", "019"};
   private Choice telch = new Choice();
   private TextField tel1tf = new TextField(4);
   private TextField tel2tf = new TextField(4);
   
   private CheckboxGroup cg = new CheckboxGroup();
      private Checkbox man = new Checkbox("남성", cg, true);
      private Checkbox woman = new Checkbox("여성", false, cg);
   
   private String[] hstr = {"영화", "음악", "독서", "게임", "쇼핑"};
   private Checkbox[] hobby = new Checkbox[hstr.length];

   private Button addbt = new Button("등록");
   private Button dispbt = new Button("분석");
   private Button updatebt = new Button("수정");
   private Button delbt = new Button("삭제");
   private Button initbt = new Button("입력모드");
   
   private List listli = new List();
   private TextArea infota = new TextArea();
   
   /* ------------------------- 메뉴관련 컴포넌트 ----------------------------------*/
   private MenuBar mb = new MenuBar();
   private Menu mfile = new Menu("File");
      private MenuItem mfnew = new MenuItem("새파일");
      private MenuItem mfopen = new MenuItem("불러오기");
      private MenuItem mfsave = new MenuItem("저장하기");
      private MenuItem mfsaveas = new MenuItem("새이름으로저장하기");
      private MenuItem mfexit = new MenuItem("종료");
   private Menu mhelp = new Menu("Help");
      private MenuItem mhver = new MenuItem("버전정보");
   
   /* ------------------------- 다이알로그관련 컴포넌트 ----------------------------------*/
   private Dialog dialog = new Dialog(this, "버전정보", true);
   private Label dlabel = new Label("Customer Manager V1.0", Label.CENTER);
   private Button dbutton = new Button("Check");
   
   private FileDialog fd = null;
   /* ------------------------- 기타관련 컴포넌트 ----------------------------------*/
   private java.util.List<Customer> data = new java.util.ArrayList<Customer>();
   private File myfile = null;
   
   public CustomerManager(){
      super("CustomerManager");
      setMenu();      //   메뉴 구성
      setDialog();   //   다이알로그 구성
      buildGUI();      //   화면 구성
      setEvent();      //    이벤트 구성
   }

   private void setEvent() {//이벤트 연결
      mfsaveas.addActionListener(this);
      mfsave.addActionListener(this);
      mfopen.addActionListener(this);
      mfnew.addActionListener(this);
      initbt.addActionListener(this);
      delbt.addActionListener(this);
      updatebt.addActionListener(this);
      dispbt.addActionListener(this);
      listli.addItemListener(this);
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
      if(e.getSource() == addbt) {//등록버튼
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
         String mhobby = "";
         if(myhobby.length() == 0) {
            mhobby = "없음";
         }else {
            mhobby = myhobby.substring(0, myhobby.length()-1);
         }
         
         Customer myCustomer = new Customer(name, jumin, tel, gender, mhobby);
         
         data.add(myCustomer);
         listli.add(myCustomer.toString());
         infota.setText("\n\t성공적으로 데이터가 등록되었습니다.");
         try {
            Thread.sleep(500);
         }catch(InterruptedException ie) { }
         clrscr();
      }//end 등록
      if(e.getSource() == dispbt) {// 분석 버튼
         String jumin = jumin1tf.getText().trim() + jumin2tf.getText().trim();
         int[] ju = new int[jumin.length()];
         for(int i=0; i<jumin.length(); i++) {
            ju[i] = jumin.charAt(i) - 48;
         }
         // 나머지는 주민번호 계산 공식에 따라...분석
      }//end 분석
      if(e.getSource() == updatebt) {// 수정 버튼
         int index = listli.getSelectedIndex();
         Customer myCustomer = data.get(index);
         
         String tel = telch.getSelectedItem() + "-" + tel1tf.getText().trim() + "-" + tel2tf.getText().trim();
         StringBuffer myhobby = new StringBuffer();
         for(int i=0; i<hobby.length; i++) {
            if(hobby[i].getState()) {
               myhobby.append(hobby[i].getLabel());
               myhobby.append("-");
            }
         }
         if(myhobby.length() == 0) {
            myhobby.append("없음");
         }else {
            myhobby.substring(0, myhobby.length()-1);
         }
         
         myCustomer.setTel(tel);
         myCustomer.setHobby(myhobby.toString());
         
         infota.setText("\n\t성공적으로 정보가 수정되었습니다.");
         try {
            Thread.sleep(500);
         }catch(InterruptedException ie) { }
         setForm(true);
         setButton(true);
         clrscr();
      }//end 수정
      if(e.getSource() == delbt) {// 삭제 버튼
         int index = listli.getSelectedIndex();
         Customer myCustomer = data.get(index);
         
         listli.remove(index);
         data.remove(index);
         infota.setText("\n\t" + myCustomer.getName() + "님의 정보를 성공적으로 삭제하였습니다.");
         try {
            Thread.sleep(500);
         }catch(InterruptedException ie) { }
         setForm(true);
         setButton(true);
         clrscr();
      }//end 삭제
      if(e.getSource() == initbt) {// 입력모드
         setForm(true);
         setButton(true);
         clrscr();
      }//end 입력모드
      if(e.getSource() == mfnew) {//새파일
         myfile = null;
         data.clear();
         listli.removeAll();
         setForm(true);
         setButton(true);
         clrscr();
         return;
      }
      if(e.getSource() == mfopen) {//불러오기
         fd = new FileDialog(this, "불러오기", FileDialog.LOAD);
         fd.setVisible(true);
         String fileName = fd.getFile();
         String folder = fd.getDirectory();
         if(fileName == null || folder == null) return;
         myfile = new File(folder, fileName);
         //openFile();//실제 열기
         loadData();
      }
      if(e.getSource() == mfsave) {//저장하기
         if(myfile == null) {
            fd = new FileDialog(this, "저장하기", FileDialog.SAVE);
            fd.setVisible(true);
            String fileName = fd.getFile();
            String folder = fd.getDirectory();
            if(fileName == null || folder == null) return;
            myfile = new File(folder, fileName);
         }
         //saveFile();
         saveData();
      }
      if(e.getSource() == mfsaveas) {//새이름으로저장하기
         fd = new FileDialog(this, "새이름으로저장하기", FileDialog.SAVE);
         fd.setVisible(true);
         String fileName = fd.getFile();
         String folder = fd.getDirectory();
         if(fileName == null || folder == null) return;
         myfile = new File(folder, fileName);
         //saveFile();//실제 저장
         saveData();
      }
   }

   public void loadData() {// ObjectStream 이용
      data.clear();
      listli.removeAll();
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      try {
         fis = new FileInputStream(myfile);
         ois = new ObjectInputStream(fis);
         while(true) {
            Customer myCustomer = (Customer) ois.readObject();
            listli.add(myCustomer.toString());
            data.add(myCustomer);
         }
      }catch(EOFException eofe) {
         infota.setText("\n\t파일의 끝까지 데이터를 로드하였습니다.");
      }catch(ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         try { if(ois != null) ois.close(); }catch(IOException ioe) { }
         try { if(fis != null) fis.close(); }catch(IOException ioe) { }
      }
   }
   
   public void saveData() {// ObjectStream 이용
      FileOutputStream fos = null;
      ObjectOutputStream oos = null;
      try {
         fos = new FileOutputStream(myfile);
         oos = new ObjectOutputStream(fos);
         for(int i=0; i<data.size(); i++) {
            Customer myCustomer = data.get(i);
            oos.writeObject(myCustomer);
         }
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         try { if(oos != null) oos.close(); }catch(IOException ioe) {}
         try { if(fos != null) fos.close(); }catch(IOException ioe) {}
      }
   }
   
   public void openFile() {
      data.clear();
      listli.removeAll();
      FileReader fr = null;
      BufferedReader br = null;
      try {
         fr = new FileReader(myfile);
         br = new BufferedReader(fr);
         String mystr = "";
         while((mystr = br.readLine()) != null) {
            String[] imsiData = mystr.split("/");
            boolean myGender = false;
            if(imsiData[3].equals("남성")) myGender = true;
            Customer myCustomer = new Customer(imsiData[0], imsiData[1], imsiData[2], myGender, imsiData[4]);
            data.add(myCustomer);
            listli.add(myCustomer.toString());
         }
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         try { if(br != null) br.close(); }catch(IOException ioe) { }
         try { if(fr != null) fr.close(); }catch(IOException ioe) { }
      }
   }
   
   public void saveFile() { // 날로 저장하기
      FileWriter fw = null;
      BufferedWriter bw = null;
      PrintWriter pw = null;
      try {
         fw = new FileWriter(myfile);
         bw = new BufferedWriter(fw);
         pw = new PrintWriter(bw, true);
         
         for(int i=0; i<data.size(); i++) {
            Customer myCustomer = data.get(i);
            StringBuffer mystr = new StringBuffer();
            mystr.append(myCustomer.getName());   mystr.append("/");
            mystr.append(myCustomer.getJumin());mystr.append("/");
            mystr.append(myCustomer.getTel());   mystr.append("/");
            mystr.append(myCustomer.isGender() ? "남성" : "여성"); mystr.append("/");
            mystr.append(myCustomer.getHobby());
            pw.println(mystr.toString());
         }//end for
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         if(pw != null) pw.close();
         try { if(bw != null) bw.close(); }catch(IOException ioe) { }
         try { if(fw != null) fw.close(); }catch(IOException ioe) { }
      }
   }
   
   @Override
   public void itemStateChanged(ItemEvent e) {
      if(e.getSource() == telch) {
         tel1tf.requestFocus(); return;
      }
      if(e.getSource() == listli) {
         int index = listli.getSelectedIndex();
         Customer myCustomer = data.get(index);
         
         nametf.setText(myCustomer.getName());
         jumin1tf.setText(myCustomer.getJumin().substring(0, 6));
         jumin2tf.setText(myCustomer.getJumin().substring(6));
         String[] phone = myCustomer.getTel().split("-");
         telch.select(phone[0]);
         tel1tf.setText(phone[1]);
         tel2tf.setText(phone[2]);
         man.setState(myCustomer.isGender());
         woman.setState(!myCustomer.isGender());
         for(int i=0; i<hobby.length; i++)
            hobby[i].setState(false);
         String[] myhobby = myCustomer.getHobby().split("-");
         for(int i=0; i<hobby.length; i++) {
            for(int j=0; j<myhobby.length; j++) {
               if(hobby[i].getLabel().equals(myhobby[j])) {
                  hobby[i].setState(true); break;
               }
            }
         }
         
         setButton(false);
         setForm(false);
      }
   }
   
   public void setForm(boolean state) {
      nametf.setEnabled(state);
      jumin1tf.setEnabled(state);
      jumin2tf.setEnabled(state);
      man.setEnabled(state);
      woman.setEnabled(state);
   }
   
   public void clrscr() {
      nametf.setText("");
      jumin1tf.setText("");
      jumin2tf.setText("");
      telch.select(0);
      tel1tf.setText("");
      tel2tf.setText("");
      man.setState(true);
      for(int i=0; i<hobby.length; i++)
         hobby[i].setState(false);
      infota.setText("");
      nametf.requestFocus();
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
   
   private void setMenu() {//메뉴구성
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
   
   private void buildGUI() {//화면구성
      setBackground(Color.CYAN);
      add("North", new Label());
      add("West", new Label());
      add("East", new Label());
      add("South", new Label());
      
      Panel mainPanel = new Panel(new BorderLayout(5,5));
         Panel southPanel = new Panel(new BorderLayout(5,5));
            southPanel.add("North", new Label("고 객 정 보 분 석 결 과", Label.CENTER));
            southPanel.add("Center", infota);
         mainPanel.add("South", southPanel);
         
         Panel eastPanel = new Panel(new BorderLayout(5,5));
            eastPanel.add("North", new Label("전 체 목 록", Label.CENTER));
            eastPanel.add("Center", listli);
         mainPanel.add("East", eastPanel);
         
         Panel centerPanel = new Panel(new BorderLayout(5,5));
            centerPanel.add("North", new Label("고 객 정 보 입 력", Label.CENTER));
            
            Panel cwPanel = new Panel(new GridLayout(5,1,5,5));
               cwPanel.add(new Label("이        름 : ", Label.RIGHT));
               cwPanel.add(new Label("주민번호 : ", Label.RIGHT));
               cwPanel.add(new Label("전화번호 : ", Label.RIGHT));
               cwPanel.add(new Label("성        별 : ", Label.RIGHT));
               cwPanel.add(new Label("취        미 : ", Label.RIGHT));
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
                  p5.add(new Label());// 안넣으면 마지막 쇼핑이 안보임.
               ccPanel.add(p5);
            centerPanel.add("Center", ccPanel);
         mainPanel.add("Center", centerPanel);
      add("Center", mainPanel);
      
      pack();
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
      
      setButton(true);
      setForm(true);
      nametf.requestFocus();
      
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new CustomerManager();
   }



}