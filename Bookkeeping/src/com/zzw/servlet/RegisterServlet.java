package com.zzw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzw.entity.User;
import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;




public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String name= request.getParameter("uname");
		String pwd= request.getParameter("upwd");
		String sex= request.getParameter("usex");
		User user = new User(name,pwd,sex);
		//接口 x=new 实现类（）
		IUserService userservice = new UserServiceImpl();
		boolean result=userservice.Register(user);
	
		if(!result) {
			request.setAttribute("message","error");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
			request.setAttribute("message","noerror");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
