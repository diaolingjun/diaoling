package com.zzw.service.Impl;




import java.util.List;


import com.zzw.dao.IUserDao;
import com.zzw.dao.Impl.UserDaoImpl;
import com.zzw.entity.Bill;
import com.zzw.entity.User;
import com.zzw.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userdao= new UserDaoImpl();
	//��¼
	 public boolean Login(User user) {
	  	  boolean flag=false;
	  	if(userdao.Login(user.getUname(),user.getUpwd())) {
	  		  flag=true;
	  	}
	  	return flag;
	 }
	//ע��
    public boolean Register(User user) {
  	  boolean flag=false;
  	  if(!userdao.isExist(user.getUname())) {
  		  userdao.Register(user);
  		  flag=true;
  	  }else {
  		  System.out.println("�����Ѵ���");
  	  }
  	 return flag; 
    }
  //�����˺Ų�ѯ�û�
    public User Query(String uname) {
  	  return userdao.Query(uname);
    }
    //����
    public boolean  AddBill(Bill bill) {
    	boolean flag=false;
    	if(userdao.AddBill(bill)) {
    	   flag=true;
    	}
    	return flag;
    }
    //������Ŀ��Ž���ɾ��
    public boolean DeleteBill(int  bid) {
  	  boolean flag=false;
  	  if(userdao.isExist(bid)) {
  		  userdao.DeleteBill(bid);
  		  flag=true;
  	  }else {
  		  System.out.println("����Ŀ������");
  	  }
  	 return flag; 
    }
    //������Ŀ��Ž����޸�
    public boolean UpdateBill(int bid,Bill bill) {
  	  boolean flag=false;
  	  if(userdao.isExist(bid)) {
  		  userdao.UpdateBill(bid,bill);
  		  flag=true;
  	  }else {
  		  System.out.println("����Ŀ������");
  	  }
  	 return flag; 
    }

    //������Ŀ��Ų�ѯ��Ŀ
    public Bill Query(int bid) {
  	  return userdao.Query(bid);
    }
	//�����������Ͳ�ѯ�˵���Ϣ
		public List<Bill> QueryType(String btype){
			return userdao.QueryType(btype);
		}
		//�������ڲ�ѯ�˵���Ϣ
		public List<Bill> QueryDate(String bdate) {
			return userdao.QueryDate(bdate);
		}
  //�����������ͺ����ڲ�ѯ�˵���Ϣ
		public List<Bill> QueryPart(String btype,String bdate) {
		return userdao.QueryPart(btype, bdate);
		}
    //��ѯȫ���˵���Ϣ
   	public List<Bill> QueryAll() {
   	return userdao.QueryAll();
   	}
}
