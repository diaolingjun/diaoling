package com.zzw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
	//���ݿ�URL���˺�����
			private static final String URL="jdbc:mysql://localhost:3306/bookkeeping?serverTimezone=UTC&characterEncoding=utf-8";
			private static final String UNAME="root";
			private static final String UPWD="vayne";
			public static PreparedStatement  pstmt=null;
			public static ResultSet  rs = null;
			public static Connection  connection=null;
			
			
     //��ɾ��
	 public static boolean executeUpdate(String sql,Object [] params) {
		 boolean flag = false;
     	try {
     		
     	//a.�������������ؾ����������
     	Class.forName("com.mysql.cj.jdbc.Driver");
     	//b.�����ݿ⽨������
     	connection = DriverManager.getConnection(URL,UNAME,UPWD);
     	
     	pstmt = connection.prepareStatement(sql);
     	for(int i=0;i<params.length;i++) {
     		pstmt.setObject(i+1, params[i]);
     	}
     	int count=pstmt.executeUpdate();//����ֵ��ʾ����ɾ�ļ�������
     	//������
     	if(count>0)
     	{
     		System.out.println("�����ɹ�������");
     		flag=true;
     	}
     	
     	}catch(ClassNotFoundException e) {
     		e.printStackTrace();
     	}catch(SQLException e) {
     		e.printStackTrace();
     	}catch(Exception e){
     		e.printStackTrace();
     	}finally {
     		try {
     			//�ȿ��ĺ�أ��󿪵��ȹ�
     		if(pstmt!=null)pstmt.close();
     		if(connection !=null)connection.close();
     		}catch(SQLException e) {
     			e.printStackTrace();
     		}finally {
     			
     		}
     	}
		return flag;
	 }
	//��
	 public static ResultSet executeQuery(String sql,Object [] params) {
		 
		     	try {
		     		
		     	//a.�������������ؾ����������
		     	Class.forName("com.mysql.cj.jdbc.Driver");
		     	//b.�����ݿ⽨������
		     	connection = DriverManager.getConnection(URL,UNAME,UPWD);
		     	
		     	pstmt = connection.prepareStatement(sql);
		     	if(params!=null) {
		     	for(int i=0;i<params.length;i++) {
		     		pstmt.setObject(i+1, params[i]);
		     	}
		     	}
		     	 rs = pstmt.executeQuery();
		     	 return rs;
		     	}catch(ClassNotFoundException e) {
		     		e.printStackTrace();
		     		return null;
		     	}catch(SQLException e) {
		     		e.printStackTrace();
		     		return null;
		     	}catch(Exception e){
		     		e.printStackTrace();
		     		return null;
		     	}
		     
		}
}
