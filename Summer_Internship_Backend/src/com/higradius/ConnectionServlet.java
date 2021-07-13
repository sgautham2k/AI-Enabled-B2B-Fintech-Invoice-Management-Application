package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionServlet {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_dataset";
	static final String USER = "root";
	static final String PASS = "3110";
	
	public static Connection connectToDB() throws Exception {
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
}