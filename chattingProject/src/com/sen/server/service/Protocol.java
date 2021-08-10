package com.sen.server.service;

import java.io.Serializable;

public class Protocol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// �������� 100 �α��� ��û
		// �������� 101 �α׾ƿ� ��û
		// �������� 102 ȸ������ ��û
		// �������� 200 �α��μ���
		// �������� 202 ȸ������ ����
		// �������� 300 �α��� ���� �߸��� ���̵�
		// �������� 301 �α��� ���� �߸��� ��й�ȣ
		// �������� 302 ȸ������ ���� �����ϴ� ���̵�
		// �������� 500 �޼��� ���� ��ü ����
		// �������� 501 �ӼӸ�
	public static final int LOGIN_REQUEST = 100;
	public static final int LOGOUT_REQUEST = 101;
	public static final int JOIN_REQUEST = 102;
	
	public static final int LOGIN_SUCCESS = 200;
	public static final int JOIN_SUCCESS = 202;
	
	public static final int LOGIN_FAIL_ID = 300;
	public static final int LOGIN_FAIL_PW = 301;
	public static final int JOIN_FAIL_EXIST_ID = 302;
	public static final int LOGIN_FAIL_BANNED = 303;
	
	public static final int SEND_ALL = 500;
	public static final int SEND_WHISPER = 501;
	public static final int WHiSPER_FAIL = 502;
	
	public static final int WELCOME_TEXT = 707;
	protected static final int BANNED_ID = 444;
	
}
