package com.sen.javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView3 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("title");
		/* ����ȭ�� ��ü���� */
		BorderPane root = new BorderPane();
		/* ��Ʈ�� ��ü���� */
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
		/* �����̳� ȭ�� ��ġ - ��Ʈ�� �߰� */
		root.setTop(btn1);
		root.setLeft(btn2);
		root.setCenter(btn3);
		root.setRight(btn4);
		root.setBottom(btn5);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(MainView3.class);
	}
}
