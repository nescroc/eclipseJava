package com.sen.client.starter;

import com.sen.client.viewload.ViewLoader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunService extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource(
						"../../../../com/sen/client/fxml/RoomList.fxml"));
		
		Parent root = loader.load();
		
		ViewLoader.roomListController = loader.getController();
		
		ViewLoader.roomListController.setStage(stage);
		
		Scene scene = new Scene(root);
		
		stage.sizeToScene();
		
		stage.setScene(scene);
		
		stage.setResizable(false);
		
		stage.show();
		System.out.println("여기까지");
	}

	@Override
	public void stop() throws Exception {
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
