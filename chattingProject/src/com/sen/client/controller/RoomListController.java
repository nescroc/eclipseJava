package com.sen.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.client.service.Login;
import com.sen.client.service.SocektService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RoomListController implements Initializable {
	
	public Stage stage;
	@FXML
	public StackPane roomList;
	@FXML 
	public Button loginbt;
	SocektService socketService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginbt.setOnAction(e->{
			Login login = new Login();
			try {
				login.show();
			} catch (Exception e2) {e2.printStackTrace();}
		});
		socketService = new SocektService();
		socketService.socketInit();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
