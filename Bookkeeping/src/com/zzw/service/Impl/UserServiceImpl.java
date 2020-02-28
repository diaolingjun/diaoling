package com.zzw.service.Impl;




import java.util.List;


import com.zzw.dao.IUserDao;
import com.zzw.dao.Impl.UserDaoImpl;
import com.zzw.entity.Bill;
import com.zzw.entity.User;
import com.zzw.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userdao= new UserDaoImpl();
	//登录
	 public boolean Login(User user) {
	  	  boolean flag=false;
	  	if(userdao.Login(user.getUname(),user.getUpwd())) {
	  		  flag=true;
	  	}
	  	return flag;
	 }
	//注册
    public boolean Register(User user) {
  	  boolean flag=false;
  	  if(!userdao.isExist(user.getUname())) {
  		  userdao.Register(user);
  		  flag=true;
  	  }else {
  		  System.out.println("此人已存在");
  	  }
  	 return flag; 
    }
  //根据账号查询用户
    public User Query(String uname) {
  	  return userdao.Query(uname);
    }
    //记账
    public boolean  AddBill(Bill bill) {
    	boolean flag=false;
    	if(userdao.AddBill(bill)) {
    	   flag=true;
    	}
    	return flag;
    }
    //根据账目编号进行删除
    public boolean DeleteBill(int  bid) {
  	  boolean flag=false;
  	  if(userdao.isExist(bid)) {
  		  userdao.DeleteBill(bid);
  		  flag=true;
  	  }else {
  		  System.out.println("此账目不存在");
  	  }
  	 return flag; 
    }
    //根据账目编号进行修改
    public boolean UpdateBill(int bid,Bill bill) {
  	  boolean flag=false;
  	  if(userdao.isExist(bid)) {
  		  userdao.UpdateBill(bid,bill);
  		  flag=true;
  	  }else {
  		  System.out.println("此账目不存在");
  	  }
  	 return flag; 
    }

    //根据账目编号查询账目
    public Bill Query(int bid) {
  	  return userdao.Query(bid);
    }
	//根据消费类型查询账单信息
		public List<Bill> QueryType(String btype){
			return userdao.QueryType(btype);
		}
		//根据日期查询账单信息
		public List<Bill> QueryDate(String bdate) {
			return userdao.QueryDate(bdate);
		}
  //根据消费类型和日期查询账单信息
		public List<Bill> QueryPart(String btype,String bdate) {
		return userdao.QueryPart(btype, bdate);
		}
    //查询全部账单信息
   	public List<Bill> QueryAll() {
   	return userdao.QueryAll();
   	}
}
