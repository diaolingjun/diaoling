package com.zzw.dao;

import java.util.List;

import com.zzw.entity.Bill;
import com.zzw.entity.User;

public interface IUserDao {
	//注册
	public  boolean Register(User user) ;
	//查询账户是否存在
	public  boolean isExist(String uname) ;
	//登录
	public  boolean Login(String uname,String upwd) ;
    //根据帐号查询用户全部信息
    public   User Query(String uname) ;
    //记账
    public  boolean AddBill(Bill bill);
    //根据账目编号删除账目信息
    public  boolean DeleteBill(int bid);
  //根据账目编号修改账目信息
	public  boolean UpdateBill(int bid,Bill bill) ;
	//查询账目是否存在
	public boolean isExist(int bid) ;
	//根据账目编号查询账目信息
	public   Bill Query(int bid);
	//根据消费类型查询账单信息
	public List<Bill> QueryType(String btype);
	//根据日期查询账单信息
	public List<Bill> QueryDate(String bdate) ;
	//根据消费类型和日期查询账单信息
	public List<Bill> QueryPart(String btype,String bdate) ;
    //查询全部账单信息
   	public List<Bill> QueryAll() ;
   	
}