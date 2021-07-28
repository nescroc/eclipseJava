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
		/* FXML을 이용한 컨테이너 객체생성 */
		try {
			
			URL resource = getClass().getResource("CustomerLayout.fxml");
			System.out.println(1);
			AnchorPane root = (AnchorPane) FXMLLoader.load(resource);
			System.out.println(2);
			Scene scene = new Scene(root);
			System.out.println(3);
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
