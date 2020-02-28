package com.zzw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.zzw.entity.Bill;
import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;


public class QueryBillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取待查询修改人的学号
		int id= Integer.parseInt(request.getParameter("bid"));
		
		IUserService userservice = new UserServiceImpl();
		Bill bill=userservice.Query(id);
		//out对象的获取方法
		PrintWriter out = response.getWriter();
		out.println(bill);
		request.setAttribute("bill", bill);
		request.getRequestDispatcher("billinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
