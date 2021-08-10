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
 * Server�� �����ϴ� Controller
 */
public class ServerController implements Initializable {

	// �������� or �������� ��ư
	@FXML
	public Button serverInitBt;
	// ���ΰ�ħ ��ư
	@FXML
	public Button refreshBt;
	@FXML
	public Button serverStopBt;
	@FXML
	public Button btnBlock;
	@FXML
	public Button logbt;
	// ���â : ���÷���
	@FXML
	public TextArea txtDisplay;
	// ���â : ������ ��
	@FXML
	public TextField threadSize;
	// ���â : ������ ��
	@FXML
	public TextField roomCount;
	@FXML
	public TextField clientSize;

	// ���� ��������
	public Stage stage;
	// ���� ���� Ŭ����
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

	/** ���� �������� �ʱ�ȭ **/
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/*** ���ΰ�ħ ��ư ***/
	public void btnRefresh(ActionEvent event) {
		updateStatus();
	}

	/*** ���ΰ�ħ ��� ***/
	public void updateStatus() {
		Platform.runLater(() -> {
			// ������ ��
			threadSize.setText(String.valueOf(SysInfo.threadPoolExecutor.getPoolSize()));
			// ������ ��
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
