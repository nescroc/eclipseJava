package com.sen.pcms.customer.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.clientserver.CustomerClientThread;
import com.sen.pcms.customer.fxml.CustomerController;
import com.sen.pcms.server.PcmsServerThread;
import com.sen.pcms.util.Protocol;

public class CustomerServerService {
	
	private CustomerController controller;	
	public HashMap<Integer,PcmsServerThread> clientList;
	public CustomerServerService(CustomerController controller) {
		this.controller = controller;
			
	}
	public void setBtnTest() {
		
		}	
	public void setSeatCombo(Set<Integer> seatAble) {
		//Iterator<Integer> iter= seatAble.iterator();
		for (Integer seatNum : seatAble) {
			controller.list.add(seatNum);	
		}
		
	}
	
	public void serviceAnalysis(CustomerVO cv,CustomerClientThread cct) throws IOException {
		
		int protocol = cv.getProtocol();
		switch (protocol) {
		case Protocol.LOGIN_TRY:
			
			break;
		case Protocol.LOGIN_SUCCESS:			
			break;

		case Protocol.LOGOUT:			
			break;

		case Protocol.LOGIN_FAIL:			
			break;

		case Protocol.LOGIN_FAIL_SEAT:			
			break;

		case Protocol.CLIENT_UPDATE:			
			break;

		case Protocol.CLIENT_DELETE:			
			break;

		case Protocol.CLIENT_SEARCH:			
			break;

		case Protocol.FIRST_JOIN:			
			break;

		case Protocol.FIND_ID:			
			break;

		case Protocol.FIND_PW:			
			break;
		case Protocol.ID_AVAILABLE:			
			break;
		case Protocol.SEND_MESSAGE:			
			break;
		case Protocol.SUSPEND_SERVICE:			
			break;
		case Protocol.RESTART_SERVICE:			
			break;
		case Protocol.MOVE_SEAT:			
			break;
		case Protocol.SHOW_SEAT:
				setSeatCombo(cv.getSeatAble());
			break;
		


		}
	}
	
	public void setThreadMap(HashMap<Integer,PcmsServerThread> clientList) {
		this.clientList = clientList;
	}
	public CustomerServerService getPcmsServerServiceImpl() {
		return this;
	}
	
}
