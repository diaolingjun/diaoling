package com.zzw.service;

import java.util.List;

import com.zzw.entity.Bill;
import com.zzw.entity.User;

public interface IUserService {
	//登录
		 public boolean Login(User user);
	//注册
		 public boolean Register(User user) ;
	//根据账号查询用户
		 public User Query(String uname) ;
	//记账
		 public boolean  AddBill(Bill bill) ;
	//根据账目编号进行删除
		 public boolean DeleteBill(int  bid);	
	//根据账目编号进行修改
		 public boolean UpdateBill(int bid,Bill bill) ;
	//根据账目编号查询账目
		 public Bill Query(int bid) ;
	//根据消费类型查询账单信息
		public List<Bill> QueryType(String btype);
	//根据日期查询账单信息
		public List<Bill> QueryDate(String bdate) ;
	//根据消费类型和日期查询账单信息
		 public List<Bill> QueryPart(String btype,String bdate) ;
	//查询全部账单信息
		 public List<Bill> QueryAll() ;
}
