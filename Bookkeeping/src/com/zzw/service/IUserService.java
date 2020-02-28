package com.zzw.service;

import java.util.List;

import com.zzw.entity.Bill;
import com.zzw.entity.User;

public interface IUserService {
	//��¼
		 public boolean Login(User user);
	//ע��
		 public boolean Register(User user) ;
	//�����˺Ų�ѯ�û�
		 public User Query(String uname) ;
	//����
		 public boolean  AddBill(Bill bill) ;
	//������Ŀ��Ž���ɾ��
		 public boolean DeleteBill(int  bid);	
	//������Ŀ��Ž����޸�
		 public boolean UpdateBill(int bid,Bill bill) ;
	//������Ŀ��Ų�ѯ��Ŀ
		 public Bill Query(int bid) ;
	//�����������Ͳ�ѯ�˵���Ϣ
		public List<Bill> QueryType(String btype);
	//�������ڲ�ѯ�˵���Ϣ
		public List<Bill> QueryDate(String bdate) ;
	//�����������ͺ����ڲ�ѯ�˵���Ϣ
		 public List<Bill> QueryPart(String btype,String bdate) ;
	//��ѯȫ���˵���Ϣ
		 public List<Bill> QueryAll() ;
}
