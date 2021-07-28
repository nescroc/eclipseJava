package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExam {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 검색 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패");
			System.exit(0);
		}
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			conn = DriverManager.getConnection(url, "mytest", "mytest");
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
//			String query = "select * from mytable";
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
			
			String query = "select * from mytable where age > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 30);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int age =rs.getInt("age");
				String address = rs.getString("address");
				if(address ==null)address=" ";
				java.sql.Date date = rs.getDate("birth");
				java.util.Date d = new java.util.Date(date.getTime());
				System.out.println(num +"\t"+ name+"\t"+ address+"\t" +age+"\t" +d.toString() );
			}
			
		} catch (SQLException e) {
			System.err.println("쿼리문 오류");
			e.printStackTrace();
		}finally {
			try {if (rs!=null)rs.close();} catch (SQLException e2) {}
//			try {if (stmt!=null)stmt.close();} catch (SQLException e2) {}
			try {if (pstmt!=null)pstmt.close();} catch (SQLException e2) {}
			try {if (conn!=null)conn.close();} catch (SQLException e2) {}
		}
	}
}
