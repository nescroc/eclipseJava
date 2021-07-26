package com.sen.javafxml5;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		
		TextField textField = new TextField();
		pane.setBottom(textField);
		textField.setText("CSS¼³Á¤:±Û¾¾Å©±â 14pt, »ö»ó :»¡°­");
		textField.setText("-fx-font-size:14pt; -fx-text-fill:red");
		
		pane.setStyle("-fx-background-color:pink;");
		
		primaryStage.setScene(new Scene(pane,400,100));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
