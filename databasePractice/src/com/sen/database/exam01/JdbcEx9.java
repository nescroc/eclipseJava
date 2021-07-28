package com.sen.database.exam01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

public class JdbcEx9 {

	public static void main(String[] args) throws Exception {
		// keyboard와 연결된 스트림 얻기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("sql 입력 : ");
		String sql = br.readLine();
		Connection con = ConnUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		// 쿼리수행 결과 집합의 부가정보를 가지고 있는 ResultSetMetaData 얻기
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("컬럼의 갯수 : " + rsmd.getColumnCount());

		// 컬럼 이름
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println();
		// 컬럼타입
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnTypeName(i)+"\t");
		}
		System.out.println();
		int 컬럼갯수 = rsmd.getColumnCount();
		while (rs.next()) {
			for (int 컬럼번호 = 1; 컬럼번호 <= 컬럼갯수; 컬럼번호++) {
				int 컬럼타입 = rsmd.getColumnType(컬럼번호);
				switch (컬럼타입) {
				case Types.NUMERIC:
					System.out.print(rs.getInt(컬럼번호)+"\t");
					break;
				case Types.VARCHAR:
					System.out.print(rs.getString(컬럼번호)+"\t");
					break;
				case Types.DATE:
					System.out.print(rs.getDate(컬럼번호)+"\t");
					break;
				}
			}			
			System.out.println();
		}
		br.close(); rs.close(); pstmt.close(); con.close();
	}

}
