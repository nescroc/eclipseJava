package com.sen.pcms.customer.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class CustomerController implements Initializable {
	
	@FXML
	private Button btn1;
	@FXML
	private TextArea textArea1;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textArea1.setText("textArea1");
		textArea1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				System.out.println(event.getText());
			};
		});
	}

	@FXML public void click(ActionEvent event) {
		textArea1.setText("버튼클릭 이벤트");
	}

}
