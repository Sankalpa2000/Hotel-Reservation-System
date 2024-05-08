package com.oop.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.oop.util.ConnectDB;

public class PaymentService {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean PaymentInsert( String cusName, String address ,String cardType, String cardNo, String cVV, String amount ) {
		boolean isSuccess = false;
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "insert into payment values (0,'"+cusName+"','"+cardType+"','"+cardNo+"','"+cVV+"','"+address+"','"+amount+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess;
	}
}

