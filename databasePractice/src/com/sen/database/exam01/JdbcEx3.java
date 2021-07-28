package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx3 {
	
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete department ");
		sql.append("where dname = '���ڰ���а�' ");
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
			stmt = con.createStatement();
			int x = stmt.executeUpdate(sql.toString());
			System.out.println(x+"���� ���� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(stmt!=null)stmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		} 
		
		
	}
	
}
