package com.sen.javaFx;

import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("����ȭ��");
		/* ����ȭ�� ��ü���� */
		Pane root = new Pane();

		/* ��ư ��Ʈ�� �߰� */
		Button btn = new Button("��ư");
		btn.setPrefSize(100, 30);
		btn.setLayoutX(10);
		btn.setLayoutY(10);
		/** �ؽ�Ʈ�ʵ� ��Ʈ�� �߰� */
		TextField textField = new TextField("���߰��ο�����");
		textField.setPrefSize(200, 30);
		textField.setLayoutX(10);
		textField.setLayoutY(50);

		/** ��Ʈ�� ����ȭ������ �߰� */
		root.getChildren().addAll(btn, textField);

		/** ��ưŬ�� �̺�Ʈ ���� */
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				/** �̺�Ʈ ���� ���� - ����ð��� textField�� ��Ÿ���� */
				Date time = new Date();
				textField.setText(time.toString());
			}
		});
		Scene scene = new Scene(root,300,200);
		stage.setScene(scene);
		stage.show();
	}
	static public void main(String args[]) {
		Application.launch(MainView2.class);
	}
}
