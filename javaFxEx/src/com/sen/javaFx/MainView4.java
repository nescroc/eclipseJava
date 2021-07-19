package com.sen.javaFx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView4 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("title");
		/* ����ȭ�� ��ü���� */
		//FlowPane root = new FlowPane();
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		
		/** ��Ʈ�� ��ü ����*/
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		Button btn3 = new Button("��ư3");
		Button btn4 = new Button("��ư4");
		Button btn5 = new Button("��ư5");

		/** ��ư�� ũ�⸦ �Ҵ�� ������ �ִ�� �����ϱ� ���� �ִ밪 ���� */
		btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		/* �����̳� ȭ���ġ - ��Ʈ�� �߰�*/
		root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		
		Scene scene = new Scene(root,300,100);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(MainView4.class);
	}
}
