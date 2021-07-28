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
		// keyboard�� ����� ��Ʈ�� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("sql �Է� : ");
		String sql = br.readLine();
		Connection con = ConnUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		// �������� ��� ������ �ΰ������� ������ �ִ� ResultSetMetaData ���
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("�÷��� ���� : " + rsmd.getColumnCount());

		// �÷� �̸�
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println();
		// �÷�Ÿ��
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnTypeName(i)+"\t");
		}
		System.out.println();
		int �÷����� = rsmd.getColumnCount();
		while (rs.next()) {
			for (int �÷���ȣ = 1; �÷���ȣ <= �÷�����; �÷���ȣ++) {
				int �÷�Ÿ�� = rsmd.getColumnType(�÷���ȣ);
				switch (�÷�Ÿ��) {
				case Types.NUMERIC:
					System.out.print(rs.getInt(�÷���ȣ)+"\t");
					break;
				case Types.VARCHAR:
					System.out.print(rs.getString(�÷���ȣ)+"\t");
					break;
				case Types.DATE:
					System.out.print(rs.getDate(�÷���ȣ)+"\t");
					break;
				}
			}			
			System.out.println();
		}
		br.close(); rs.close(); pstmt.close(); con.close();
	}

}
