package com.sen.javafxml6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane= new BorderPane();
		
		TextField textField = new TextField();
		pane.setBottom(textField);
		textField.setText("CSS¼³Á¤:±Û¾¾Å©±â 14pt, »ö»ó:»¡°­");
		
		Scene scene =new Scene(pane,400,100);
		
		String urlStr = getClass().getResource("design.css").toExternalForm();
		scene.getStylesheets().add(urlStr);
		
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch();
	}

}
