package com.sen.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.client.service.Login;
import com.sen.client.service.SocketService;
import com.sen.client.util.Config;
import com.sen.server.service.Packet;
import com.sen.server.service.Protocol;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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
	@FXML
	public TextField whisperId;

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		Config.socketService = new SocketService();
		Config.socketService.socketInit();
		loginbt.setOnAction(e->{
			if (loginbt.getText().equals("로그인")) {
				Login login = new Login();
				try {
					login.show();
				} catch (Exception e2) {e2.printStackTrace();}
			}else if (loginbt.getText().equals("로그아웃")) {
				Platform.runLater(()->{
					loginbt.setText("로그인");
				});
				Config.socketService.socketDestory();
			}			
		});
		Platform.runLater(()->{
			roomchatArea.appendText("환영합니다. \n");
		});
		roomInputField.setOnAction((e)->{
			sendRoomchat(e);
		});
		loginbt.setText("로그아웃");
		roomchatArea.appendText("root 님 반갑습니다. \n");
		createbt.setDisable(false);
		searchbt.setDisable(false);
		idLabel.setText("root");
		
	}	
	
	
	public void sendRoomchat(ActionEvent e) {
		Runnable rn = new Runnable() {			
			@Override
			public void run() {
				String toId =whisperId.getText().trim();
				String message = roomInputField.getText();
				
				if (!toId.equals("")&&!message.equals("")) {
					Packet whisperPacket = new Packet();
					
					whisperPacket.setProtocol(Protocol.SEND_WHISPER);
					whisperPacket.setMessage(message);
					whisperPacket.setToId(toId);
					if (Config.userInfo.getCid()!=null) { 
						whisperPacket.setCid(Config.userInfo.getCid());						
					}else {
						whisperPacket.setIp(Config.userInfo.getIp());
					}
					
					Config.socketService.sender(whisperPacket);
					return;
				}
				
				Packet packet = new Packet();
				packet.setProtocol(Protocol.SEND_ALL);
				if (Config.userInfo.getCid()!=null) { 
					packet.setCid(Config.userInfo.getCid());						
				}else {
					packet.setIp(Config.userInfo.getIp());
				}
				packet.setMessage(message);				
				Config.socketService.sender(packet);
			}
		};
		Thread t = new Thread(rn);
		t.start();
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
