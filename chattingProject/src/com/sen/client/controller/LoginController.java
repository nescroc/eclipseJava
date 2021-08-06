package com.sen.client.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import com.sen.client.util.Config;
import com.sen.client.util.Inspector;

import javafx.application.Platform;
import javafx.concurrent.Task;
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
		loginbt.setOnAction(e->{
			loginAction(e);
		});
		loginArea.setOnAction(e->{
			loginAction(e);
		});
		newjoinbt.setOnAction(e->{
			Platform.runLater(()->{
				resultlb.setStyle("-fx-text-fill:red;" 
						+ "-fx-font-size:11;");
				resultlb.setText("���� ��������");
			});
		});
	}

	/** ��Ʈ�ѷ� �ʱ�ȭ **/
	public void set(Stage stage) {
		this.stage = stage;
	}

	/** �޽��� �� ���� **/
	public void setLabel(String text) {
		resultlb.setText(text);
	}
	
	
	/** ���̵� ��, ��ư �̺�Ʈ ó��**/
	public void loginAction(ActionEvent event) {
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {

				try {

					String id = loginArea.getText();

					if (Inspector.isWhiteSpace(id)) {

						Platform.runLater(() -> {

							resultlb.setText("���� ���� �Ұ�");
							resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
							loginArea.clear();
							pwdArea.clear();
						});
						return null;
					}
					Charset charset = Charset.forName("UTF-8");
					ByteBuffer byteBuffer = charset.encode(id);
					Config.socketChannel.write(byteBuffer);
				} catch (IOException ioe) {

					Platform.runLater(() -> {
						resultlb.setStyle("-fx-text-fill:red;" + "-fx-font-size:13;");
						resultlb.setText("���� �̿���");
					});
				}
				return null;
			}

		};
		Thread thread = new Thread(task);
		thread.start();
	}
}
