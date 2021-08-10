package com.sen.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.client.util.Config;
import com.sen.client.util.Inspector;
import com.sen.server.service.Packet;
import com.sen.server.service.Protocol;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	public Stage stage;

	@FXML
	public Button loginbt;
	@FXML
	public TextField loginArea;
	@FXML
	public PasswordField pwdArea;
	@FXML
	public Button newjoinbt;
	@FXML
	public Label resultlb;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newjoinbt.setOnAction(e -> {
			joinAction(e);
		});
		loginbt.setOnAction(e -> {			
						loginAction(e);			
		});
		loginArea.setOnAction(e -> {
			loginAction(e);
		});
		pwdArea.setOnAction(e -> {
			loginAction(e);
		});
		newjoinbt.setOnAction(e -> {
			joinAction(e);
		});
	}

	private void joinAction(ActionEvent e) {
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				String id = loginArea.getText();
				String pw = pwdArea.getText();
				if (Inspector.isWhiteSpace(id)) {
					Platform.runLater(() -> {
						resultlb.setText("공백 포함 불가");
						resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
						loginArea.clear();
						pwdArea.clear();
					});
					return;
				}
				if (Inspector.isCharSize(id) || Inspector.isCharSize(pw)) {
					Platform.runLater(() -> {
						resultlb.setText("아이디 길이 오류");
						resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
						loginArea.clear();
						pwdArea.clear();
					});
					return;
				}
				Packet packet = new Packet();
				packet.setProtocol(Protocol.JOIN_REQUEST);
				packet.setCid(id);
				packet.setCpw(pw);			
				
				Config.socketService.sender(packet);
				return;
			}

		};
		Thread thread = new Thread(rn);
		thread.start();
	}

	/** 컨트롤러 초기화 **/
	public void set(Stage stage) {
		this.stage = stage;
	}

	/** 메시지 라벨 설정 **/
	public void setLabel(String text) {
		resultlb.setText(text);
	}

	/** 아이디 라벨, 버튼 이벤트 처리 **/
	public void loginAction(ActionEvent event) {
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				String id = loginArea.getText();
				String pw = pwdArea.getText();				
				if (Inspector.isWhiteSpace(id)) {
					Platform.runLater(() -> {
						resultlb.setText("공백 포함 불가");
						resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
						loginArea.clear();
						pwdArea.clear();
					});
					return;
				}
				if (Inspector.isCharSize(id) || Inspector.isCharSize(pw)) {
					Platform.runLater(() -> {
						resultlb.setText("아이디 길이 오류");
						resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
						loginArea.clear();
						pwdArea.clear();
					});
					return;
				}
				Packet packet = new Packet();
				packet.setProtocol(Protocol.LOGIN_REQUEST);
				packet.setIp(Config.userInfo.getIp());
				packet.setCid(id);
				packet.setCpw(pw);

				Config.socketService.sender(packet);
				return ;
			}

		};
		System.out.println("task 작업");
		Thread thread = new Thread(rn);
		thread.start();
	}
}
