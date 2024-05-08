package com.oop.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Customer;



public class AdminDashService {
	private String jdbcURL = "jdbc:mysql://localhost:3306/hotelsample";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Chamathka77@";
	
	private static final String SELECT_ALL_CUSTOMER = "select * from customer";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
			//select order
			public List<Customer> selectAllOrder() {
				List<Customer> order = new ArrayList<>();
					
				try (Connection connection = getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);){
					System.out.println(preparedStatement);
						
					ResultSet rs = preparedStatement.executeQuery();
						
					while (rs.next()) {
						int id = rs.getInt("CID");
						String item = rs.getString("Name");
						String qty = rs.getString("Email");
						String name = rs.getString("Phone");
						String address = rs.getString("Username");
						String code = rs.getString("Password");
						order.add(new Customer(id, item, qty, name, address, code));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return order;
			}
			
}