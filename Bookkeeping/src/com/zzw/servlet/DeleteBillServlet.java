package com.zzw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;

public class DeleteBillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int id= Integer.parseInt(request.getParameter("bid"));
		IUserService userservice = new UserServiceImpl();
		boolean result=userservice.DeleteBill(id);

		if(!result) {
			request.setAttribute("message","error");
		}else {
			request.setAttribute("message","noerror");
		}
		request.getRequestDispatcher("QueryAllBillServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
