package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcEx5 {

	public static void main(String[] args) {
		//preparedStatement�� ����ϴ� ���
		//sql�������� ���������� ��ü�� �κ��� ?�� ó���Ѵ�.
		//? db���� sql����ÿ� �������� ��ü�ȴ�.
		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor ");
		sql.append("values(?,?,?,?,?,sysdate,?,?)");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			//PreparedStatement ��ü ���
			pstmt = con.prepareStatement(sql.toString());
			//�Ķ���� ����
			//������ ?(���ε� ����)�� ��ü�� ������ �����ϱ�
			pstmt.setInt(1, 9920);
			pstmt.setString(2, "ȫ�浿");
			pstmt.setString(3, "gildong");
			pstmt.setString(4, "���ӱ���");
			pstmt.setInt(5, 450);
			pstmt.setInt(6, 40);
			pstmt.setInt(7, 203);
			//���� ����
			int i = pstmt.executeUpdate();
			System.out.println(i+" ���� ���� �߰��Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null)pstmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}
}
