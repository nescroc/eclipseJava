package com.sen.javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*����1 Application ���*/
public class MainView extends Application {
	
	
	
	
	
	/*����2 �߻�޼ҵ� ����*/
	@Override
	public void start(Stage stage) throws Exception {
		/*����3 ȭ�鼳�� -> ȭ������� ����-> �����켳��*/
		
		/** ȭ�鼳�� */
		Pane pane = new Pane(); /* ȭ�� ��ü*/
		
		/*ȭ������� ����*/
		Scene scene = new Scene(pane);/*ȭ������� ��ü*/
		
		/*������ ����*/
		stage.setScene(scene);/*ȭ������� ���*/
		
		stage.show();
		
		
	}

}
