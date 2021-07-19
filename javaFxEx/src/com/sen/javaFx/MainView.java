package com.sen.javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*절차1 Application 상속*/
public class MainView extends Application {
	
	
	
	
	
	/*절차2 추상메소드 구현*/
	@Override
	public void start(Stage stage) throws Exception {
		/*절차3 화면설정 -> 화면관리자 설정-> 윈도우설정*/
		
		/** 화면설정 */
		Pane pane = new Pane(); /* 화면 객체*/
		
		/*화면관리자 설정*/
		Scene scene = new Scene(pane);/*화면관리자 객체*/
		
		/*윈도우 설정*/
		stage.setScene(scene);/*화면관리자 등록*/
		
		stage.show();
		
		
	}

}
