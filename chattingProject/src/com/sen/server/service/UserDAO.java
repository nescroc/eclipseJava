package com.sen.server.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sen.server.util.ConnUtil;
import com.sen.server.viewload.ServerViewLoader;

public class UserDAO {
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
				if (rs.getInt("banned") == 0) {
					if (cpw.equals(rs.getString("cpw"))) {
						return Protocol.LOGIN_SUCCESS;
					}
					return Protocol.LOGIN_FAIL_PW;
				} else {
					return Protocol.LOGIN_FAIL_BANNED;
				}
			}
		} catch (SQLException e) {}
		return Protocol.LOGIN_FAIL_ID;
	}

	public ArrayList<String> getBlackList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> banList = new ArrayList<String>();
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_banList"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				banList.add(rs.getString("cid"));
			}
			return banList;
		} catch (SQLException e) {
		}
		return null;
	}

	public int addBlack(String banId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_banAble"));
			pstmt.setString(1, banId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("banned")==0) {
					pstmt = conn.prepareStatement(props.getProperty("chat_banId"));
					pstmt.setString(1, banId);
					result = pstmt.executeUpdate();					
				}				
			}else if(!rs.next()){
				ServerViewLoader.svc0.txtDisplay.appendText("존재하지 않는 id 입니다.");
			}
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	public int unBanId(String unbanId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(props.getProperty("chat_unbanId"));
			pstmt.setString(1, unbanId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			return result;
			}
		return result;
	}

}
