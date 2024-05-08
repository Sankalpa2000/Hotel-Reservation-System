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

@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		
		boolean isTrue;
		
		isTrue = AdminService.deleteAdmin(cid);
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AdminRegistration.jsp");
			dis.forward(request, response);
		}else {
			List<Admin> admDetails = AdminService.getAdmin(cid);
			request.setAttribute("admDetails", admDetails);
			RequestDispatcher dis = request.getRequestDispatcher("AdminAccount.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
