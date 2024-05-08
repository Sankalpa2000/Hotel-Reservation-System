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

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String cid = request.getParameter("cid");
		
		boolean isTrue;
		
		isTrue = CustomerService.deleteCustomer(cid);
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("CustomerRegistration.jsp");
			dis.forward(request, response);
		}else {
			List<Customer> cusDetails = CustomerService.getCustomerDetails(cid);
			request.setAttribute("cusDetails", cusDetails);
			RequestDispatcher dis = request.getRequestDispatcher("CustomerAccount.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
