package com.sen.database.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcEx10 {

	public static void main(String[] args) {
		Properties pro = new Properties();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			pro.load(new FileInputStream("src/department.properties"));
			con = ConnUtil.getConnection();
			//department.properties�� ���ǵ� sql�� �����ͼ�
			//preparedstatement �����
			pstmt = con.prepareStatement(pro.getProperty("department_insert"));
			//parameter(���ε������� �� �Ҵ��ϱ�) �����ϱ�
			pstmt.setInt(1,100);
			pstmt.setString(2, "������а�");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "5ȣ��");
			int i = pstmt.executeUpdate();
			System.out.println(i+"���� ���� �߰��Ǿ����ϴ�.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null)pstmt.close();} catch (Exception e2) {}
			try {if(con!=null)con.close();} catch (Exception e2) {}
		}
		
	}

}
