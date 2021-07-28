package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcEx6 {

	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update  professor ");
		sql.append("set sal = ? ");
		sql.append("where name = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 500);
			pstmt.setString(2, "홍길동");
			int i = pstmt.executeUpdate();
			System.out.println(i+"개의 행이 변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null)pstmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}

}
