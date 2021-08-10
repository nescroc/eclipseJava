package com.sen.server.service;

import java.io.IOException;

import com.sen.server.viewload.ServerViewLoader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/* -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
public class Block {
	
	public void show() throws IOException {		
		Stage stage = new Stage();
		stage.setTitle("블랙리스트");
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../../../../com/sen/server/fxml/Block.fxml"));
		Parent root = (Parent) loader.load();
		
		ServerViewLoader.svc1 = loader.getController();
		ServerViewLoader.svc1.setStage(stage);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.show();
	}

}
