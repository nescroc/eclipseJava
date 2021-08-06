package com.sen.server.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BlockController implements Initializable{
	@FXML private ListView<String> blacklist;
	@FXML private TextField nameInput;
	public Stage stage;
	
	//QueryBlock q = new QueryBlock();

	String deleteName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		blacklist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					deleteName = newValue;
			}
		});
		
		
	}

	/** 블랙리스트 스테이지 초기화 **/
	public void setStage(Stage stage) {
		this.stage = stage;
		update();
	}
	
	/** 추가 **/
	public void btnAdd(ActionEvent event) throws IOException {
		Platform.runLater(()-> {
			//q.addIP(nameInput.getText());
			nameInput.clear();
		});
		update();
	}
	/** 삭제 **/
	public void btnDelete(ActionEvent event) throws IOException {
		Platform.runLater(()-> {
		//	q.deleteIP(deleteName);
			nameInput.clear();
			
		});
		update();
	}
	/** 업데이트 **/
	public void update() {
		Platform.runLater(()-> {
			//ObservableList<String> ol = FXCollections.observableList(q.showIP());
			//blacklist.setItems(ol);
		});
	}
}
