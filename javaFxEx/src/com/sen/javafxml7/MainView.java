package com.sen.javafxml7;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage)  {
		try {
			URL resource =getClass().getResource("RootLayout.fxml");
			AnchorPane root = (AnchorPane)FXMLLoader.load(resource);
			Scene scene = new Scene(root);
			
			String urlStr = getClass().getResource("design.css").toExternalForm();
			scene.getStylesheets().add(urlStr);
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
