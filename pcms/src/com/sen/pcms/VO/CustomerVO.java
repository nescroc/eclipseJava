package com.sen.pcms.VO;

import java.io.Serializable;
import java.util.Date;

public class CustomerVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int  protocol;
	private int cno;//회원번호
	private String cid;
	private String cname;
	private String cnum;//휴대폰번호
	

	private int csec; //보유시간
	private Date cdate;
	private String caddress;
	private String cpwd;
	private String cemail;
	private int grant;
	// ----------------서버가 가지고 있어야할 상태들---------
	private String msg;
	private int cstatus;
	private int seatNo;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCstatus() {
		return cstatus;
	}

	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}

	@Override
	public String toString() {
		return "CustomerVO [cid=" + cid + ", cname=" + cname + ", cnum=" + cnum + ", csec=" + csec + ", cdate=" + cdate
				+ ", caddress=" + caddress + ", cpwd=" + cpwd + ", cemail=" + cemail + ", cno=" + cno + ", grant="
				+ grant + ", msg=" + msg + ", cstatus=" + cstatus + "]";
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public int getCsec() {
		return csec;
	}

	public void setCsec(int csec) {
		this.csec = csec;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getGrant() {
		return grant;
	}

	public void setGrant(int grant) {
		this.grant = grant;
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

}
