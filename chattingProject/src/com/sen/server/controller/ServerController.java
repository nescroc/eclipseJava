package com.sen.server.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sen.server.service.Block;
import com.sen.server.service.ServerSocketService;
import com.sen.server.util.SysInfo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Server를 구동하는 Controller
 */
public class ServerController implements Initializable {

	// 서버시작 or 서버종료 버튼
	@FXML
	public Button serverInitBt;
	// 새로고침 버튼
	@FXML
	public Button refreshBt;
	@FXML
	public Button serverStopBt;
	@FXML
	public Button btnBlock;
	@FXML
	public Button logbt;
	// 출력창 : 디스플레이
	@FXML
	public TextArea txtDisplay;
	// 출력창 : 스레드 수
	@FXML
	public TextField threadSize;
	// 출력창 : 접속자 수
	@FXML
	public TextField roomCount;
	@FXML
	public TextField clientSize;

	// 메인 스테이지
	public Stage stage;
	// 서버 구동 클래스
	ServerSocketService serverSocketService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clientSize.setText("0");
		roomCount.setText("0");
		threadSize.setText("0");
		btnBlock.setOnAction(e -> {
			Block block = new Block();
			try {
				block.show();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		});

	}

	/** 서버 스테이지 초기화 **/
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/*** 새로고침 버튼 ***/
	public void btnRefresh(ActionEvent event) {
		updateStatus();
	}

	/*** 새로고침 기능 ***/
	public void updateStatus() {
		Platform.runLater(() -> {
			// 스레드 수
			threadSize.setText(String.valueOf(SysInfo.threadPoolExecutor.getPoolSize()));
			// 접속자 수
			clientSize.setText(String.valueOf(SysInfo.users.size()));
		});
	}

	@FXML
	public void serverInit(ActionEvent e) {
		Runnable rn = new Runnable() {

			@Override
			public void run() {
				serverSocketService = new ServerSocketService();
				serverSocketService.serverInit();

			}
		};
		Thread thread = new Thread(rn);
		thread.start();
		Platform.runLater(() -> {
			serverStopBt.setDisable(false);
			serverInitBt.setDisable(true);
			btnBlock.setDisable(false);
			refreshBt.setDisable(false);
		});
	}

	@FXML
	public void serverStop(ActionEvent e) {
		serverSocketService.serverStop();
		serverInitBt.setDisable(false);
		serverStopBt.setDisable(true);
		btnBlock.setDisable(true);
		refreshBt.setDisable(true);
	}
	public void displayClear() {
		txtDisplay.setText("");
		threadSize.setText("0");
		clientSize.setText("0");
	}
}
