package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static String url = "jdbc:mysql://localhost:3306/hotelsample";
	private static String username = "root";
	private static String password = "Chamathka77@";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("Database Connection Unsuccessful!!!");
			e.printStackTrace();
		}
		return con;
	}
}
