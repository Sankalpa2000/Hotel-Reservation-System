package com.oop.servlet;

import java.sql.Connection;
import java.sql.Statement;

import com.oop.util.ConnectDB;

public class HotelService {
	private static Connection con = null;
	private static Statement stmt = null;
	
	public static boolean insertHotel(String name, String address, String phone, String ownerName, String hType, String price) {
		boolean isSuccess = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
						
			String sql = "insert into hotel values (0,'"+name+"','"+address+"','"+phone+"','"+ownerName+"','"+hType+"','"+price+"')";
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
