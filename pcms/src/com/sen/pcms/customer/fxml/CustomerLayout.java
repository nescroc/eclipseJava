package com.sen.pcms.customer.fxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomerLayout extends Application {

	@Override
	public void start(Stage stage) {
		/* FXML을 이용한 컨테이너 객체생성 */
		try {
			System.out.println(1);
			URL resource = getClass().getResource("LoginLayout.fxml");
			System.out.println(resource.toString());
			AnchorPane root = (AnchorPane) FXMLLoader.load(resource);
			Scene scene = new Scene(root);
			stage.setResizable(false);
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
