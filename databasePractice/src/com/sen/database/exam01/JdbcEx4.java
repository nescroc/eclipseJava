package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcEx4 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("select deptno, dname, college, loc");
		sql.append(" from department");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//thin Type jdbc ����̹� :
			//��ü ��Ʈ�p protocol ������ �ִ� jdbc ����̹�...
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			//resultset�� next()�޼ҵ�� Ŀ���� ���������� �̵���Ŵ
			//�̵��� ��ġ�� row�� �����ϸ� true, �������� ������ false�� ��ȯ�Ѵ�.
			//rs.next �� ���� ����, �� ������տ� ���� �����ϴ� ����
			//ResultSet���κ��� ������ ����..
			while(rs.next()) {
				//Ŀ���� ��ġ�� row�� ������ column���� �� �����ϱ�
				//resultset�� getXXX(�÷���ġ), getXXX(�÷��̸�)
				//�� ����ؼ� column�� �� ����
					int i = rs.getInt("deptno");
					String s1 = rs.getString("dname");
					int j = rs.getInt("college");
					String s2 = rs.getString("loc");
					System.out.println(i+"\t"+s1+"\t"+j+"\t"+s2);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs!=null)rs.close();} catch (Exception e2) {}
			try {if(stmt!=null)stmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}
}

