package com.sen.client.service;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cno;
	private String cid;
	private String cpw;
	private int banned;
	private String ip;
	
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
