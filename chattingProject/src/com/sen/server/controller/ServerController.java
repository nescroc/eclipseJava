package com.sen.server.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sen.server.service.Block;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
  Server를 구동하는 Controller
 */
public class ServerController implements Initializable {

	// 서버시작 or 서버종료 버튼
	@FXML
	public Button serverInitBt;
	// 새로고침 버튼
	@FXML
	public Button refreshBt;	
	
	@FXML
	public Button btnBlock;

	// 출력창 : 디스플레이
	@FXML
	public TextArea txtDisplay;
	// 출력창 : 스레드 수
	@FXML
	public TextField threadSize;
	// 출력창 : 접속자 수
	@FXML
	public TextField clientSize;
	
	// 메인 스테이지
	public Stage stage;
	// 서버 구동 클래스

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBlock.setOnAction(e->{
			Block block = new Block();
			 try {
				 block.show();
			} catch (IOException ioe) {
					ioe.printStackTrace();
			}
		});
		
	}

	/** 서버 스테이지 초기화**/
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void serverInit(ActionEvent e) {
		
	}
}
