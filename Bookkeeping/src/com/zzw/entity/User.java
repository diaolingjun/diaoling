package com.zzw.entity;

public class User {
      private int uid;
      private String uname;
      private String upwd;
      private String usex;
      
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + usex + "]";
	}
	
	public User() {
		
	}
	public User( String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}
	public User( String uname, String upwd, String usex) {
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
	}
	public User(int uid, String uname, String upwd, String usex) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
      
}
