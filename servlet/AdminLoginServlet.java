package com.oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Admin;
import com.oop.util.ValidateAdmin;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			boolean isTrue = ValidateAdmin.validate(username, password);
			
			if(isTrue == true) {
				List<Admin> admDetails = AdminService.getAdmin(username);
				request.setAttribute("admDetails", admDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("AdminAccount.jsp");
				dis.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
