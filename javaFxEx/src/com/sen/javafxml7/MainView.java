package com.sen.javafxml7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage)  {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RootLayout.fxml"));
			//URL resource =getClass().getResource("RootLayout.fxml");
			//System.out.println(resource);
			
			AnchorPane root = loader.load(); 
			
					//(AnchorPane)FXMLLoader.load(resource);
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
