package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx2 {

	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update department ");
		sql.append("set dname = '���ڰ���а�' ");
		sql.append("where deptno = 203 ");
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			stmt = con.createStatement();
			// update���� executeUpdate�� ����Ѵ�.
			int i = stmt.executeUpdate(sql.toString());
			System.out.println(i + " ���� ���� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Connection, statement �ڿ��ݳ�ó��
			try {if(stmt!=null)stmt.close();} catch (Exception e) {}
			try {if(con!=null)con.close();} catch (Exception e) {}
		}
	}
}
