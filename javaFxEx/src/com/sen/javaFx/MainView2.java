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
		stage.setTitle("메인화면");
		/* 메인화면 객체생성 */
		Pane root = new Pane();

		/* 버튼 컨트롤 추가 */
		Button btn = new Button("버튼");
		btn.setPrefSize(100, 30);
		btn.setLayoutX(10);
		btn.setLayoutY(10);
		/** 텍스트필드 컨트롤 추가 */
		TextField textField = new TextField("제발공부열심히");
		textField.setPrefSize(200, 30);
		textField.setLayoutX(10);
		textField.setLayoutY(50);

		/** 컨트롤 메인화면으로 추가 */
		root.getChildren().addAll(btn, textField);

		/** 버튼클릭 이벤트 정의 */
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				/** 이벤트 구현 로직 - 현재시간을 textField에 나타내기 */
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
