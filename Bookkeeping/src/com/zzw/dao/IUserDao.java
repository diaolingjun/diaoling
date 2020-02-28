package com.zzw.dao;

import java.util.List;

import com.zzw.entity.Bill;
import com.zzw.entity.User;

public interface IUserDao {
	//ע��
	public  boolean Register(User user) ;
	//��ѯ�˻��Ƿ����
	public  boolean isExist(String uname) ;
	//��¼
	public  boolean Login(String uname,String upwd) ;
    //�����ʺŲ�ѯ�û�ȫ����Ϣ
    public   User Query(String uname) ;
    //����
    public  boolean AddBill(Bill bill);
    //������Ŀ���ɾ����Ŀ��Ϣ
    public  boolean DeleteBill(int bid);
  //������Ŀ����޸���Ŀ��Ϣ
	public  boolean UpdateBill(int bid,Bill bill) ;
	//��ѯ��Ŀ�Ƿ����
	public boolean isExist(int bid) ;
	//������Ŀ��Ų�ѯ��Ŀ��Ϣ
	public   Bill Query(int bid);
	//�����������Ͳ�ѯ�˵���Ϣ
	public List<Bill> QueryType(String btype);
	//�������ڲ�ѯ�˵���Ϣ
	public List<Bill> QueryDate(String bdate) ;
	//�����������ͺ����ڲ�ѯ�˵���Ϣ
	public List<Bill> QueryPart(String btype,String bdate) ;
    //��ѯȫ���˵���Ϣ
   	public List<Bill> QueryAll() ;
   	
}