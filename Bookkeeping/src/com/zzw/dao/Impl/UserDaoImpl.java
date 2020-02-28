package com.zzw.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;

import com.zzw.dao.IUserDao;
import com.zzw.entity.Bill;
import com.zzw.entity.User;
import com.zzw.utils.DBUtil;

public class UserDaoImpl implements IUserDao{
	//ע��
			public  boolean Register(User user) {
				 String sql="insert into user(uname,upwd,usex) values(?,?,?)" ;
				 Object [] params= {user.getUname(),user.getUpwd(),user.getUsex()};
			     return  DBUtil.executeUpdate(sql, params);
			}
			//��ѯ�˻��Ƿ����
			public  boolean isExist(String uname) {
				return Query(uname)==null? false:true;
			}
	//��¼
		   public boolean Login(String uname,String upwd) {
			   return Query(uname,upwd)==null? false:true;
		   }
	//�����˺Ų�ѯ�û�ȫ����Ϣ
	public   User Query(String uname) {
		 User user= null;
	     ResultSet rs = null; 
	     try {
	    	 String sql="select * from user where uname =?" ;
	    	 Object [] params= {uname};
	    	 rs=DBUtil.executeQuery(sql, params);
	         if(rs.next()) {
	        	 String name=rs.getString("uname");
	        	 String pwd=rs.getString("upwd");
	        	 String sex=rs.getString("usex");
	        	 user= new User(name,pwd,sex);
	         }
	     }catch(SQLException e) {
	    	 e.printStackTrace();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 try {
        			//�ȿ��ĺ�أ��󿪵��ȹ�
        		if(rs!=null)rs.close();
        		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
        		if(DBUtil.connection !=null)DBUtil.connection.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}finally {
        			
        		}
	     }
	     return user;
	}
	//�����˻�����ȷ���Ƿ����
	public   User Query(String uname,String upwd) {
		 User user= null;
	     ResultSet rs = null; 
	     try {
	    	 String sql="select * from user where uname =? and upwd=?" ;
	    	 Object [] params= {uname,upwd};
	    	 rs=DBUtil.executeQuery(sql, params);
	         if(rs.next()) {
	        	 String name=rs.getString("uname");
	        	 String pwd=rs.getString("upwd");
	        	 String sex=rs.getString("usex");
	        	 user= new User(name,pwd,sex);
	         }
	     }catch(SQLException e) {
	    	 e.printStackTrace();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 try {
       			//�ȿ��ĺ�أ��󿪵��ȹ�
       		if(rs!=null)rs.close();
       		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
       		if(DBUtil.connection !=null)DBUtil.connection.close();
       		}catch(SQLException e) {
       			e.printStackTrace();
       		}finally {
       			
       		}
	     }
	     return user;
	}
	//����
    public  boolean AddBill(Bill bill) {
    	String sql="insert into bill(btype,bmoney,bdate,bremark) values(?,?,?,?)" ;
		 Object [] params= {bill.getBtype(),bill.getBmoney(),bill.getBdate(),bill.getBremark()};
	     return  DBUtil.executeUpdate(sql, params);
    }
  //������Ŀ���ɾ����Ŀ��Ϣ
  		public  boolean DeleteBill(int bid) {
  		
  			 String sql="delete from bill where bid=?" ;
  			 Object [] params= {bid};
  			 return DBUtil.executeUpdate(sql, params);
  		}
  		//������Ŀ����޸���Ŀ��Ϣ
  		public  boolean UpdateBill(int bid,Bill bill) {
  			
  			 String sql="update bill set btype =?,bmoney=?,bdate=?,bremark=? where bid =?" ;
  			 Object [] params= {bill.getBtype(),bill.getBmoney(),bill.getBdate(),bill.getBremark(),bid};
  		     return  DBUtil.executeUpdate(sql, params);
  		}
  		//��ѯ��Ŀ�Ƿ����
  	  public boolean isExist(int bid) {
		   return Query(bid)==null? false:true;
	   }
  	//������Ŀ��Ų�ѯ��Ŀ��Ϣ
  		public   Bill Query(int bid) {
  			 Bill bill= null;
  		     ResultSet rs = null; 
  		     try {
  		    	 String sql="select * from bill where bid =? " ;
  		    	 Object [] params= {bid};
  		    	 rs=DBUtil.executeQuery(sql, params);
  		         if(rs.next()) {
  		        	 int id=rs.getInt("bid");
  		        	 String type=rs.getString("btype");
  		        	 int money=rs.getInt("bmoney");
  		        	 String date=rs.getString("bdate");
  		        	 String remark=rs.getString("bremark");
  		        	 bill=new Bill(id,type,money,date,remark);
  		         }
  		     }catch(SQLException e) {
  		    	 e.printStackTrace();
  		     }catch(Exception e) {
  		    	 e.printStackTrace();
  		     }finally {
  		    	 try {
  	       			//�ȿ��ĺ�أ��󿪵��ȹ�
  	       		if(rs!=null)rs.close();
  	       		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
  	       		if(DBUtil.connection !=null)DBUtil.connection.close();
  	       		}catch(SQLException e) {
  	       			e.printStackTrace();
  	       		}finally {
  	       			
  	       		}
  		     }
  		     return bill;
  		}	
  	//�����������Ͳ�ѯ�˵���Ϣ
  		public List<Bill> QueryType(String btype) {
  			List<Bill> bills = new ArrayList<>();
  			 Bill bill= null;
  			 ResultSet rs=null;
  		     try {
  		    	
  		    		String sql="select * from bill where  btype=?" ;
  	  		    	Object [] params= {btype};
  	 		    	 rs=DBUtil.executeQuery(sql, params);
  		    	 
  		         while(rs.next()) {
  		        	 int id=rs.getInt("bid");
  		        	String type= rs.getString("btype");
  		     		int money=rs.getInt("bmoney");
  		     		String date= rs.getString("bdate");
  		     		String remark= rs.getString("bremark");
  		     		bill= new Bill(id,type,money,date,remark);
  		     		bills.add(bill);
  		         }
  		     }catch(SQLException e) {
  		    	 e.printStackTrace();
  		     }catch(Exception e) {
  		    	 e.printStackTrace();
  		     }finally {
  		    	 try {
  	        			//�ȿ��ĺ�أ��󿪵��ȹ�
  	        		if(rs!=null)rs.close();
  	        		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
  	        		if(DBUtil.connection !=null)DBUtil.connection.close();
  	        		}catch(SQLException e) {
  	        			e.printStackTrace();
  	        		}finally {
  	        			
  	        		}
  		     }
  		     return bills;
  		}
  	//�������ڲ�ѯ�˵���Ϣ
  		public List<Bill> QueryDate(String bdate) {
  			List<Bill> bills = new ArrayList<>();
  			 Bill bill= null;
  			 ResultSet rs=null;
  		     try {
  		    	    String sql="select * from bill where  bdate=?" ;
  	  		    	Object [] params= {bdate};
  	 		    	 rs=DBUtil.executeQuery(sql, params);
  		         while(rs.next()) {
  		        	 int id=rs.getInt("bid");
  		        	String type= rs.getString("btype");
  		     		int money=rs.getInt("bmoney");
  		     		String date= rs.getString("bdate");
  		     		String remark= rs.getString("bremark");
  		     		bill= new Bill(id,type,money,date,remark);
  		     		bills.add(bill);
  		         }
  		     }catch(SQLException e) {
  		    	 e.printStackTrace();
  		     }catch(Exception e) {
  		    	 e.printStackTrace();
  		     }finally {
  		    	 try {
  	        			//�ȿ��ĺ�أ��󿪵��ȹ�
  	        		if(rs!=null)rs.close();
  	        		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
  	        		if(DBUtil.connection !=null)DBUtil.connection.close();
  	        		}catch(SQLException e) {
  	        			e.printStackTrace();
  	        		}finally {
  	        			
  	        		}
  		     }
  		     return bills;
  		}
  	//�����������ͺ����ڲ�ѯ�˵���Ϣ
  		public List<Bill> QueryPart(String btype,String bdate) {
  			List<Bill> bills = new ArrayList<>();
  			 Bill bill= null;
  			 ResultSet rs=null;
  		     try {
  		    	 String sql="select * from bill where  btype=?and bdate=?" ;
  		    	 Object [] params= {btype,bdate};
 		    	 rs=DBUtil.executeQuery(sql, params);
  		         while(rs.next()) {
  		        	 int id=rs.getInt("bid");
  		        	String type= rs.getString("btype");
  		     		int money=rs.getInt("bmoney");
  		     		String date= rs.getString("bdate");
  		     		String remark= rs.getString("bremark");
  		     		bill= new Bill(id,type,money,date,remark);
  		     		bills.add(bill);
  		         }
  		     }catch(SQLException e) {
  		    	 e.printStackTrace();
  		     }catch(Exception e) {
  		    	 e.printStackTrace();
  		     }finally {
  		    	 try {
  	        			//�ȿ��ĺ�أ��󿪵��ȹ�
  	        		if(rs!=null)rs.close();
  	        		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
  	        		if(DBUtil.connection !=null)DBUtil.connection.close();
  	        		}catch(SQLException e) {
  	        			e.printStackTrace();
  	        		}finally {
  	        			
  	        		}
  		     }
  		     return bills;
  		}
  //��ѯȫ���˵���Ϣ
	public List<Bill> QueryAll() {
		List<Bill> bills = new ArrayList<>();
		 Bill bill= null;
		 ResultSet rs=null;
	     try {
	    	 String sql="select * from bill " ;
	    	 rs=DBUtil.executeQuery(sql, null);
	         while(rs.next()) {
	        	 int id=rs.getInt("bid");
	        	String type= rs.getString("btype");
	     		int money=rs.getInt("bmoney");
	     		String date= rs.getString("bdate");
	     		String remark= rs.getString("bremark");
	     		bill= new Bill(id,type,money,date,remark);
	     		bills.add(bill);
	         }
	     }catch(SQLException e) {
	    	 e.printStackTrace();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }finally {
	    	 try {
        			//�ȿ��ĺ�أ��󿪵��ȹ�
        		if(rs!=null)rs.close();
        		if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
        		if(DBUtil.connection !=null)DBUtil.connection.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}finally {
        			
        		}
	     }
	     return bills;
	}
}
