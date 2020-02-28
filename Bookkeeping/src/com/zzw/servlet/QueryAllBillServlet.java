package com.zzw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzw.entity.Bill;
import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;


public class QueryAllBillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		IUserService userservice = new UserServiceImpl();
		List<Bill> bills=userservice.QueryAll();
		//out对象的获取方法
		PrintWriter out = response.getWriter();
		request.setAttribute("bills", bills);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
