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
	//注册
			public  boolean Register(User user) {
				 String sql="insert into user(uname,upwd,usex) values(?,?,?)" ;
				 Object [] params= {user.getUname(),user.getUpwd(),user.getUsex()};
			     return  DBUtil.executeUpdate(sql, params);
			}
			//查询账户是否存在
			public  boolean isExist(String uname) {
				return Query(uname)==null? false:true;
			}
	//登录
		   public boolean Login(String uname,String upwd) {
			   return Query(uname,upwd)==null? false:true;
		   }
	//根据账号查询用户全部信息
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
        			//先开的后关，后开的先关
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
	//根据账户密码确定是否存在
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
       			//先开的后关，后开的先关
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
	//记账
    public  boolean AddBill(Bill bill) {
    	String sql="insert into bill(btype,bmoney,bdate,bremark) values(?,?,?,?)" ;
		 Object [] params= {bill.getBtype(),bill.getBmoney(),bill.getBdate(),bill.getBremark()};
	     return  DBUtil.executeUpdate(sql, params);
    }
  //根据账目编号删除账目信息
  		public  boolean DeleteBill(int bid) {
  		
  			 String sql="delete from bill where bid=?" ;
  			 Object [] params= {bid};
  			 return DBUtil.executeUpdate(sql, params);
  		}
  		//根据账目编号修改账目信息
  		public  boolean UpdateBill(int bid,Bill bill) {
  			
  			 String sql="update bill set btype =?,bmoney=?,bdate=?,bremark=? where bid =?" ;
  			 Object [] params= {bill.getBtype(),bill.getBmoney(),bill.getBdate(),bill.getBremark(),bid};
  		     return  DBUtil.executeUpdate(sql, params);
  		}
  		//查询账目是否存在
  	  public boolean isExist(int bid) {
		   return Query(bid)==null? false:true;
	   }
  	//根据账目编号查询账目信息
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
  	       			//先开的后关，后开的先关
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
  	//根据消费类型查询账单信息
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
  	        			//先开的后关，后开的先关
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
  	//根据日期查询账单信息
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
  	        			//先开的后关，后开的先关
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
  	//根据消费类型和日期查询账单信息
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
  	        			//先开的后关，后开的先关
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
  //查询全部账单信息
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
        			//先开的后关，后开的先关
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
