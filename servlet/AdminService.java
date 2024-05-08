package com.oop.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Admin;
import com.oop.util.ConnectDB;

public class AdminService {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Admin> getAdmin(String usernamei) {
		List<Admin> adm = new ArrayList<>();
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "select * from admin where Username='"+usernamei+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int Aid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Admin a = new Admin(Aid,name,email,phone,username,password);
				adm.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return adm;
	}
	
	public static boolean registerAdmin(String name,String email,String phone,String username,String password) {
		boolean isSuccess = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into admin values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
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
	public static boolean updateAdmin(String Aid ,String name ,String email , String phone ,String username ,String password) {
		boolean isSuccess = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			String sql = "update admin set Name ='"+name+"',Email = '"+email+"',Phone = '"+phone+"',Username = '"+username+"',Password = '"+password+"'"
					+ "where AID = '"+Aid+"'";
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
	public static boolean deleteAdmin(String id) {
		boolean isSuccess = false;
		int convertedID = Integer.parseInt(id);
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "delete from admin where AID= '"+convertedID+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
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














