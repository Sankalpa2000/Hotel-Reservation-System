package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusname = request.getParameter("cusname");
		String cusaddress = request.getParameter("cusaddress");
		String cardtype = request.getParameter("cardtype");
		String cardno = request.getParameter("cardno");
		String cvv = request.getParameter("cvv");
		String expdate = request.getParameter("expdate");
		String amount = request.getParameter("amount");
		
		boolean isTrue;
		isTrue = PaymentService.PaymentInsert(cusname, cusaddress, cardtype, cardno, cvv, amount);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Success.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request, response);
			
		}
		
		
	}

}
