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
  Server�� �����ϴ� Controller
 */
public class ServerController implements Initializable {

	// �������� or �������� ��ư
	@FXML
	public Button serverInitBt;
	// ���ΰ�ħ ��ư
	@FXML
	public Button refreshBt;	
	
	@FXML
	public Button btnBlock;

	// ���â : ���÷���
	@FXML
	public TextArea txtDisplay;
	// ���â : ������ ��
	@FXML
	public TextField threadSize;
	// ���â : ������ ��
	@FXML
	public TextField clientSize;
	
	// ���� ��������
	public Stage stage;
	// ���� ���� Ŭ����

	
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

	/** ���� �������� �ʱ�ȭ**/
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void serverInit(ActionEvent e) {
		
	}
}
