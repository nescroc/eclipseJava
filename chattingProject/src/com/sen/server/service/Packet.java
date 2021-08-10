package com.sen.server.service;

import java.io.Serializable;

public class Packet implements Serializable{

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
	// 
	private String toId;
	@Override
	public String toString() {
		return "Packet [toId=" + toId + ", cno=" + cno + ", cid=" + cid + ", cpw=" + cpw + ", banned=" + banned
				+ ", ip=" + ip + ", protocol=" + protocol + ", message=" + message + "]";
	}
	private int cno;
	private String cid;
	private String cpw;
	private int banned;
	private String ip;
	
	private static final long serialVersionUID = 1L;
	private int protocol;	
	private String message;
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}
	public int getBanned() {
		return banned;
	}
	public void setBanned(int banned) {
		this.banned = banned;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
