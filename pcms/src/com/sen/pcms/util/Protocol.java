package com.sen.pcms.util;

public final class Protocol {
	
	public static final int LOGIN_TRY = 100;	
	public static final int LOGIN_SUCCESS = 101;
	public static final int LOGOUT= 102;
	public static final int LOGIN_FAIL = 103;
	public static final int LOGIN_FAIL_SEAT = 104;//사용중인 자리
	
	public static final int CLIENT_UPDATE = 200;
	public static final int CLIENT_DELETE = 201;
	public static final int CLIENT_SEARCH = 202;
	public static final int FIRST_JOIN = 203;
	public static final int FIND_ID = 204;
	public static final int FIND_PW = 205;
	public static final int ID_AVAILABLE=206;
	
	public static final int SEND_MESSAGE = 300;
	public static final int SUSPEND_SERVICE = 301;
	public static final int RESTART_SERVICE = 302;
	public static final int MOVE_SEAT = 303;
	public static final int SHOW_SEAT = 304;
	
	/*
	 * public static final int POWER_ON = 600; public static final int POWER_OFF =
	 * 601;
	 */
	
	
}
