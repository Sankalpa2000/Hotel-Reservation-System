package com.oop.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Customer;
import com.oop.util.ConnectDB;

public class CustomerService {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Customer> getcustomer(String usernamei) {
		List<Customer> cus = new ArrayList<>();
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where Username='"+usernamei+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c = new Customer(cid,name,email,phone,username,password);
				cus.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	public static boolean registerCustomer(String namer, String emailr, String phoner, String usernamer, String passwordr) {
		boolean isSuccess = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
						
			String sql = "insert into customer values (0,'"+namer+"','"+emailr+"','"+phoner+"','"+usernamer+"','"+passwordr+"')";
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
	public static boolean updateCustomer(String cid ,String name ,String email , String phone ,String username ,String password) {
		boolean isSuccess = false;
		
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			
			String sql = "update customer set Name ='"+name+"',Email = '"+email+"',Phone = '"+phone+"',Username = '"+username+"',Password = '"+password+"'"
					+ "where CID = '"+cid+"'";
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
	
	public static List<Customer> getCustomerDetails(String CID){
		ArrayList<Customer> cus = new ArrayList<>();
		
		int convertedCID = Integer.parseInt(CID);
		
		try {
			
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from customer where CID = '"+convertedCID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				int cid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				
				Customer C = new Customer(cid, name, email, phone, username, password);
				cus.add(C);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	public static boolean deleteCustomer(String id) {
		boolean isSuccess = false;
		int convertedID = Integer.parseInt(id);
		try {
			con = ConnectDB.getConnection();
			stmt = con.createStatement();
			String sql = "delete from customer where CID= '"+convertedID+"'";
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




















