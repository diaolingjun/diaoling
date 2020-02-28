package com.zzw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzw.entity.User;
import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String name= request.getParameter("uname");
		String pwd= request.getParameter("upwd");
		User user = new User(name,pwd);
		//接口 x=new 实现类（）
		IUserService userservice = new UserServiceImpl();
		boolean result=userservice.Login(user);
	
		if(!result) {
			request.setAttribute("message","error");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("message","noerror");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
