package com.sen.server.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnUtil {		
		public static Connection getConnection() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return DriverManager.getConnection(					
						"jdbc:oracle:thin:@localhost:1521/XEPDB1",
						"mytest","mytest");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

}
