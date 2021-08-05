package com.sen.pcms.customer.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.pcms.clientserver.CustomerClient;
import com.sen.pcms.clientserver.CustomerClientThread;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CustomerController implements Initializable {
	
	//CustomerClient cc;
	CustomerClientThread cct;
	@FXML
	private TextField loginIdArea;
	@FXML
	private PasswordField loginPwArea;
	@FXML
	private Button loginSubmitbtn;
	@FXML
	private Button joinbtn;
	@FXML
	private Button forgetIdbtn;
	@FXML
	private Button forgetPwbtn;
	
	
	/*
	 * @FXML private ComboBox<T>
	 */
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Runnable cr = new CustomerClient(this);
		Thread ct = new Thread(cr);
		ct.start();
		/*
		 * textArea1.setText("textArea1"); textArea1.setOnKeyPressed(new
		 * EventHandler<KeyEvent>() { public void handle(KeyEvent event) {
		 * System.out.println(event.getText()); }; });
		 */
	}

	@FXML
	public void click(ActionEvent event) {
		/* textArea1.setText("버튼클릭 이벤트"); */
	}
	public void setThread(CustomerClientThread cct) {
		this.cct = cct;
	}
	
}
