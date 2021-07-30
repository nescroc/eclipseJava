package com.sen.pcms.fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PcmsLayout extends Application {
	
	
	@Override
	public void start(Stage stage) {
		/* FXML�� �̿��� �����̳� ��ü���� */
		try {
			
			URL resource = 
					getClass().getResource("PcmsLayout.fxml");			
			AnchorPane root = 
					(AnchorPane) FXMLLoader.load(resource);			
			Scene scene = new Scene(root);
			
//			Button btn1 = (Button) scene.lookup("#btn1");
//			System.out.println("btn1=" + btn1);

			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch();
		
	}
}
