package com.sen.server.service;

import java.io.Serializable;

public class Packet implements Serializable{

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
