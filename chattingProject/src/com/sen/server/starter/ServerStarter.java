package com.sen.server.starter;


import com.sen.server.viewload.ServerViewLoader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerStarter extends Application{

	@Override
	public void start(Stage stage)  {
		try {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../../../../com/sen/server/fxml/Server.fxml"));
		
		Parent root = loader.load();
		
		ServerViewLoader.svc0 = loader.getController();
		ServerViewLoader.svc0.setStage(stage);		
		Scene scene = new Scene(root);	
	
		stage.setResizable(false);	
		stage.setScene(scene);	
		stage.sizeToScene();
		stage.setOnCloseRequest(e->{
			if(ServerViewLoader.svc0!=null) {ServerViewLoader.svc0.stage.close();} 
			if(ServerViewLoader.svc1!=null) {ServerViewLoader.svc1.stage.close();}			
		});
		
		stage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
