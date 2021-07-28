package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx1 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			//jdbc 드라이브 메모리에 로드하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection 객체 얻기
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
			//statement 객체 얻기
			stmt = con.createStatement();
			//sql 작성하기
			StringBuffer sql = new StringBuffer();
			sql.append("insert into department ");
			sql.append("values (203, '제어계측공학과',200,'7호관')");
			//쿼리 실행시키기
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result+"개의 행이 추가되었습니다.");
		} catch (Exception e) {	
			e.printStackTrace();
		}finally {
			try {if(stmt!=null)stmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}
}
