package com.sen.pcms.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.server.PcmsServer;
import com.sen.pcms.service.PcmsServerServiceImpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
	private PcmsServerServiceImpl pssip;
	@FXML
	public Button searchbtn;
	@FXML
	public TextField searchArea;
	@FXML
	public TableColumn<CustomerVO,String> nameColumn ;
	@FXML
	public TableColumn<CustomerVO,String> idColumn;
	@FXML
	public TableColumn<CustomerVO,Integer> timeColumn;	
	@FXML
	public TableView<CustomerVO> searchTable;
	@FXML
	public TextField idArea;
	@FXML
	public TextField nameArea;
	@FXML 
	public TextField birthArea;
	@FXML
	public TextField timeArea;
	@FXML
	public TextField joinArea;
	@FXML
	public TextField emailArea;
	@FXML
	public TextField pnumArea;
	@FXML
	public TextField addressArea;
	@FXML
	public TextField statusArea;
	@FXML
	public Button stopbt,startbt,suspendbt,movebt,
					addtimebt,editbt,clearbt;
	@FXML
	public VBox v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12;
	public VBox[] BoxArray = {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12};
	@FXML
	public Label userLabel1,userLabel2,userLabel3,
				userLabel4,userLabel5,userLabel6,
				userLabel7,userLabel8,userLabel9,
				userLabel10,userLabel11,userLabel12,
				 
				userTime1,userTime2,userTime3,
				userTime4,userTime5,userTime6,
				userTime7,userTime8,userTime9,				
				userTime10,userTime11,userTime12,
				
				userStatus1,userStatus2, userStatus3,
				userStatus4,userStatus5, userStatus6,
				userStatus7,userStatus8,userStatus9,
				userStatus10,userStatus11,userStatus12;
	public Label[] userArray = {userLabel1,userLabel2,userLabel3,
			userLabel4,userLabel5,userLabel6,
			userLabel7,userLabel8,userLabel9,
			userLabel10,userLabel11,userLabel12};
	public Label[] timeArray = {userTime1,userTime2,userTime3,
			userTime4,userTime5,userTime6,
			userTime7,userTime8,userTime9,
			userTime10,userTime11,userTime12};
	public Label[] statusArray = {userStatus1,userStatus2, userStatus3,
			userStatus4,userStatus5, userStatus6,
			userStatus7,userStatus8,userStatus9,
			userStatus10,userStatus11,userStatus12};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		nameColumn = new TableColumn<>();
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cname"));
		
		idColumn = new TableColumn<>();
		idColumn.setCellValueFactory(new PropertyValueFactory<>("cid"));
		
		timeColumn = new TableColumn<>();
		idColumn.setCellValueFactory(new PropertyValueFactory<>("csec"));
		
	
		pssip = new PcmsServerServiceImpl(this);	
		
		
		Runnable rn = new PcmsServer(pssip);
		Thread t = new Thread(rn);
		t.start();
		
	
		
	}
	
	
}
