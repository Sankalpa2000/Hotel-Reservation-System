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

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = AdminService.updateAdmin(cid, name, email, phone, username, password);
		if(isTrue == true) {
			
			List<Admin> admDetails = AdminService.getAdmin(name);
			request.setAttribute("admDetails", admDetails);
			RequestDispatcher dis = request.getRequestDispatcher("AdminAccount.jsp");
			dis.forward(request, response);
		}
		else {
			List<Admin> admDetails = AdminService.getAdmin(name);
			request.setAttribute("admDetails", admDetails);
			RequestDispatcher dis = request.getRequestDispatcher("AdminAccount.jsp");
			dis.forward(request, response);
		}
	}

}
