package com.sen.database.exam01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcEx7 {

	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.name, a.profno,a.sal, a.position,b.dname ");
		sql.append("from professor a, department b ");
		sql.append("where a.deptno = b.deptno ");
		sql.append("and a.deptno = ? ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			//?(���ε�����)�� ��ü�� ������ ����
			pstmt.setInt(1, 203);
			//���� ������Ѽ� ��������� ���
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getInt("profno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getInt("sal")+"����\t");
				System.out.println(rs.getString("position")+"\t");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(rs!=null)rs.close();} catch (Exception e2) {}
			try {if(pstmt!=null)pstmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
	}

}
