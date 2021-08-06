package com.sen.client.service;

import java.io.IOException;

import com.sen.client.viewload.ViewLoader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login  {
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
  public void show() throws IOException {
	
    Stage stage = new Stage();	
	stage.setTitle("·Î±×ÀÎ");
	FXMLLoader loader = new FXMLLoader(
			getClass().getResource("../../../../com/sen/client/fxml/Login.fxml"));
	Parent root = (Parent) loader.load();
	ViewLoader.loginController= loader.getController();
	ViewLoader.loginController.set(stage);
			
	Scene scene = new Scene(root);
			
	stage.setScene(scene);
	stage.setResizable(false);
	stage.show();	
  }
}
