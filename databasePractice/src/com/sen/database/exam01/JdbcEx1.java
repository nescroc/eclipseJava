package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx1 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			//jdbc ����̺� �޸𸮿� �ε��ϱ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection ��ü ���
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
			//statement ��ü ���
			stmt = con.createStatement();
			//sql �ۼ��ϱ�
			StringBuffer sql = new StringBuffer();
			sql.append("insert into department ");
			sql.append("values (203, '����������а�',200,'7ȣ��')");
			//���� �����Ű��
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result+"���� ���� �߰��Ǿ����ϴ�.");
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {if(stmt!=null)stmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}
}
