package com.oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Customer;
import com.oop.util.ValidateCustomer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			boolean isTrue = ValidateCustomer.validate(username, password);
			
			if(isTrue == true) {
				List<Customer> cusDetails = CustomerService.getcustomer(username);
				request.setAttribute("cusDetails", cusDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("CustomerAccount.jsp");
				dis.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
