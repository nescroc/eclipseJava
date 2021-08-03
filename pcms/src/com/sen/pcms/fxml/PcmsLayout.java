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

			URL resource = getClass().getResource("PcmsLayout.fxml");
			AnchorPane root = (AnchorPane) FXMLLoader.load(resource);
			Scene scene = new Scene(root);
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public static void main(String[] args) {
		launch();
	}
}
