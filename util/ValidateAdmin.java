package com.oop.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ValidateAdmin {

	private static boolean isSuccess = false;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String username, String password) {
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "select * from admin where Username='"+username+"' and Password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
