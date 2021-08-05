package com.sen.pcms.service;

import java.io.IOException;
import java.util.HashMap;

import com.sen.pcms.VO.CustomerVO;
import com.sen.pcms.clientserver.CustomerClientThread;
import com.sen.pcms.customer.fxml.CustomerController;
import com.sen.pcms.server.PcmsServerThread;
import com.sen.pcms.util.Protocol;

public class CustomerServerService {

	private CustomerController customerController;

	public HashMap<Integer, PcmsServerThread> clientList;

	public CustomerServerService(CustomerController customerController) {
		this.customerController= customerController;

	}

	

	public void serviceAnalysis(CustomerVO cv, CustomerClientThread pst) throws IOException {

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
			showSeat();
			break;

		}
	}

	private void showSeat() {
	}

	public void setThreadMap(HashMap<Integer, PcmsServerThread> clientList) {
		this.clientList = clientList;
	}

	
}
