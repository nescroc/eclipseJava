package com.sen.server.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sen.server.service.ServerSocketService;
import com.sen.server.util.SysInfo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BlockController implements Initializable {
	@FXML
	private ListView<String> blacklist;
	@FXML
	private TextField nameInput;
	@FXML
	private Button blockbt;
	@FXML
	private Button removebt;
	public Stage stage;
	ArrayList<String> banList;
	ObservableList<String> list;
	// QueryBlock q = new QueryBlock();

	String deleteName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		blockbt.setOnAction((e) -> {
			btnAdd(e);
		});
		blacklist.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		banList = SysInfo.userDAO.getBlackList();
		list = FXCollections.observableArrayList(banList);

		Platform.runLater(() -> {
			blacklist.setItems(list);
		});

		removebt.setOnAction((e) -> {
			btnRemove(e);
		});
		nameInput.setOnAction((e) -> {
			btnAdd(e);
		});
	}

	/** 블랙리스트 스테이지 초기화 **/
	public void setStage(Stage stage) {
		this.stage = stage;

	}

	/** 추가 **/
	public void btnAdd(ActionEvent event) {
		Runnable rn = new Runnable() {

			@Override
			public void run() {
				String banId = nameInput.getText();
				if (SysInfo.userDAO.addBlack(banId) == 1) {
					Platform.runLater(() -> {
						list.add(banId);
						blacklist.setItems(list);
						nameInput.clear();
					});
					ServerSocketService.banId(banId);
				} else {
					System.out.println("블랙리스트실패");
				}
			}
		};
		Thread t = new Thread(rn);
		t.start();

	}

	/** 삭제 **/
	public void btnRemove(ActionEvent event) {
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				String unbanId = blacklist.getSelectionModel().getSelectedItem();
				if (SysInfo.userDAO.unBanId(unbanId) == 1) {
					Platform.runLater(() -> {
						list.remove(unbanId);
						blacklist.setItems(list);
					});

				}
			}
		};
		Thread t = new Thread(rn);
		t.start();

	}

}
