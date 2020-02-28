package com.zzw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zzw.entity.Bill;
import com.zzw.service.IUserService;
import com.zzw.service.Impl.UserServiceImpl;


public class UpdateBillServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//��ȡ���޸��˵�ѧ��
		int id= Integer.parseInt(request.getParameter("bid"));
		//��ȡ�޸ĺ������
		String type=request.getParameter("btype");
		int money= Integer.parseInt(request.getParameter("bmoney"));
		String date= request.getParameter("bdate");
		String remark= request.getParameter("bremark");
		//���޸ĺ�����ݷ�װ��һ��ʵ������
		Bill bill = new Bill(type,money,date,remark);
		IUserService userservice = new UserServiceImpl();
		boolean result=userservice.UpdateBill(id,bill);
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
