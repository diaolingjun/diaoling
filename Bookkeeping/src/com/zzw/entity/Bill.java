package com.zzw.entity;

public class Bill {
      private int bid;
      private String btype;
      private int bmoney;
      private String bdate;
      private String bremark;
      
	public Bill() {
	}
	public Bill(int bmoney, String bdate, String bremark) {
		this.bmoney = bmoney;
		this.bdate = bdate;
		this.bremark = bremark;
	}
	public Bill(String btype, int bmoney, String bdate, String bremark) {
		this.btype = btype;
		this.bmoney = bmoney;
		this.bdate = bdate;
		this.bremark = bremark;
	}
	public Bill(int bid, String btype, int bmoney, String bdate, String bremark) {
		this.bid = bid;
		this.btype = btype;
		this.bmoney = bmoney;
		this.bdate = bdate;
		this.bremark = bremark;
	}
	@Override
	public String toString() {
		return "Bill [bid=" + bid + ", btype=" + btype + ", bmoney=" + bmoney + ", bdate=" + bdate + ", bremark="
				+ bremark + "]";
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public int getBmoney() {
		return bmoney;
	}
	public void setBmoney(int bmoney) {
		this.bmoney = bmoney;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBremark() {
		return bremark;
	}
	public void setBremark(String bremark) {
		this.bremark = bremark;
	}
      
}
