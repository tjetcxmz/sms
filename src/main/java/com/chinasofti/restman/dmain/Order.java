package com.chinasofti.restman.dmain;

import java.io.Serializable;
import java.sql.Date;


public class Order implements Serializable{
	private String orid;
	private Date ordate;
	private int stid;
	private int cuid;
	@Override
	public String toString() {
		return "订单编号："+this.orid+" 订单日期："+this.ordate+" 员工号："+this.stid+" 客户号："+this.cuid;
	}
	public Order(String orid, Date ordate, int stid, int cuid) {
		super();
		this.orid = orid;
		this.ordate = ordate;
		this.stid = stid;
		this.cuid = cuid;
	}
	public Order(String ordate, int stid, int cuid) { // 重载的构造方法
		super();

		this.stid = stid;
		this.cuid = cuid;
	}

	

	public Order(Date ordate, int cuid) {
		super();
		this.ordate = ordate;
		this.cuid = cuid;
	}

	public Order(String orid, Date ordate, int cuid) {
		super();
		this.orid = orid;
		this.ordate = ordate;
		this.cuid = cuid;
	}

	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrid() {
		return orid;
	}
	public void setOrid(String orid) {
		this.orid = orid;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public int getCuid() {
		return cuid;
	}
	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	
	
}
