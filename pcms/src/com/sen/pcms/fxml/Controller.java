package com.sen.pcms.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.pcms.server.PcmsServer;
import com.sen.pcms.service.PcmsServerServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {
	private PcmsServerServiceImpl pssip;
	@FXML
	public Button searchbtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pssip = new PcmsServerServiceImpl(this);
		
		Runnable rn = new PcmsServer(pssip);
		Thread t = new Thread(rn);
		t.start();		
		pssip.setBtnTest();
	}
	

}
