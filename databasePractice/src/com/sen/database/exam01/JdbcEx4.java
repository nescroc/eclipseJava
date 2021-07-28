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
			//thin Type jdbc 드라이버 :
			//자체 네트웤 protocol 가지고 있는 jdbc 드라이버...
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1","mytest","mytest");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			//resultset의 next()메소드는 커서를 다음행으로 이동시킴
			//이동된 위치에 row가 존재하면 true, 존재하지 않으면 false를 반환한다.
			//rs.next 가 참인 동안, 즉 결과집합에 행이 존재하는 동안
			//ResultSet으로부터 데이터 추출..
			while(rs.next()) {
				//커서가 위치한 row의 각각의 column에서 값 추출하기
				//resultset의 getXXX(컬럼위치), getXXX(컬럼이름)
				//을 사용해서 column의 값 추출
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

