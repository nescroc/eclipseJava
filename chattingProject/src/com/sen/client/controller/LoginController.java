package com.sen.client.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends Application {

	public Stage stage;

	@FXML
	public Button loginbt;
	
	@FXML
	public TextField loginArea;
	@FXML
	public PasswordField pwdArea;
	@FXML
	public Label resultlb;
	@Override
	public void start(Stage arg0) throws Exception {
	}

}
