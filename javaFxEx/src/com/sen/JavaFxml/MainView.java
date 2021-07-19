package com.sen.JavaFxml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		URL resource = getClass().getResource("RootLayout.fxml");

		AnchorPane root = (AnchorPane) FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
