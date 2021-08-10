package com.sen.server.service;

import java.io.Serializable;

public class Protocol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// 프로토콜 100 로그인 요청
		// 프로토콜 101 로그아웃 요청
		// 프로토콜 102 회원가입 요청
		// 프로토콜 200 로그인성공
		// 프로토콜 202 회원가입 성공
		// 프로토콜 300 로그인 실패 잘못된 아이디
		// 프로토콜 301 로그인 실패 잘못된 비밀번호
		// 프로토콜 302 회원가입 실패 존재하는 아이디
		// 프로토콜 500 메세지 전송 전체 전송
		// 프로토콜 501 귓속말
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
