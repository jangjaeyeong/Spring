package com.kh.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER = "C##JDBC";
	private final static String PW = "JDBC";
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			
			System.out.println("DB연결 실패");
			e.printStackTrace();
			return null;
		}
		return conn;
	}
	
}
