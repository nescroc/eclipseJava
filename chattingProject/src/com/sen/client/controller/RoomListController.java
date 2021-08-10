package com.sen.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.client.service.Login;
import com.sen.client.service.SocketService;
import com.sen.client.util.Config;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RoomListController implements Initializable {
	
	public Stage stage;
	@FXML
	public StackPane roomList;
	@FXML 
	public Button loginbt;
	@FXML
	public Button searchbt;
	@FXML
	public Button createbt;
	@FXML
	public TextArea roomchatArea;
	@FXML
	public TextField roomInputField;
	@FXML
	public Label idLabel;
	
	;
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		Config.socketService = new SocketService();
		Config.socketService.socketInit();
		loginbt.setOnAction(e->{
			Login login = new Login();
			try {
				login.show();
			} catch (Exception e2) {e2.printStackTrace();}
		});
		
		
		
	}	
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
