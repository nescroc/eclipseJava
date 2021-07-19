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
		/* 메인화면 객체생성 */
		//FlowPane root = new FlowPane();
		FlowPane root = new FlowPane(Orientation.VERTICAL);
		
		/** 컨트롤 객체 생성*/
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("버튼4");
		Button btn5 = new Button("버튼5");

		/** 버튼의 크기를 할당된 영역에 최대로 설정하기 위해 최대값 설정 */
		btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		/* 컨테이너 화면배치 - 컨트롤 추가*/
		root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		
		Scene scene = new Scene(root,300,100);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(MainView4.class);
	}
}
