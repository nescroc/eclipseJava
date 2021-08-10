package com.sen.server.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.sen.server.util.ConnUtil;

public class UserDAO {

	/*
	 * 
	 * 
	 * chat_idAble select cid from chat where cid = ? chat_joinMember insert into
	 * chat(cno,cid,cpw) values(cno_sequence.nextVal,?,?)
	 * 
	 * chat_login select cid,cpw from chat where c
	 * 
	 * chat_banId update chat set banned = 1 where cid = ? chat_unbanId update chat
	 * set banned = 0 where cid = ?
	 * 
	 * chat_banList select cid from chat where banned = 1
	 * 
	 */

	private Properties props;
	private Connection conn;

	public UserDAO() {
		props = new Properties();
		;
		try {
			props.load(new FileInputStream("src/dbproperties/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		conn = ConnUtil.getConnection();
	}

	public boolean idAble(String cid) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_idAble"));

			pstmt.setString(1, cid);

			rs = pstmt.executeQuery();

			if (rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int insertUser(String cid, String cpw) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_joinMember"));
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			System.out.println(props.getProperty("chat_joinMember"));
			System.out.println(cid + cpw);
			System.out.println("어디까지");
			int r = pstmt.executeUpdate();
			System.out.println("왔나");
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int chatLogin(String cid, String cpw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_login"));
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (cpw.equals(rs.getString("cpw"))) {
					return Protocol.LOGIN_SUCCESS;
				}
				return Protocol.LOGIN_FAIL_PW;
			}
		} catch (SQLException e) {}
		return Protocol.LOGIN_FAIL_ID;
	}

}
