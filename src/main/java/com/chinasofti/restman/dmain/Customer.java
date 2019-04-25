package com.chinasofti.restman.dmain;

import java.io.Serializable;

//顾客类
public class Customer implements Serializable{
	//客户号
	private int cuId;
	//客户名
	private String cuName;
	//客户的会员类型
	private String memtype;
	//余额
	private double cubal;
	//是否被冻结
	private int frozen;
	
	public Customer() {
		
	}
	
	public Customer(int cuid, String cuname, String memtype, double cubal) {
		super();
		this.cuId = cuid;
		this.cuName = cuname;
		this.memtype = memtype;
		this.cubal = cubal;
		
	}

	public int getCuid() {
		return cuId;
	}

	public void setCuid(int cuid) {
		this.cuId = cuid;
	}

	public String getCuname() {
		return cuName;
	}

	public void setCuname(String cuname) {
		this.cuName = cuname;
	}

	public String getMemtype() {
		return memtype;
	}

	public void setMemtype(String memtype) {
		this.memtype = memtype;
	}

	public double getCubal() {
		return cubal;
	}

	public void setCubal(double cubal) {
		this.cubal = cubal;
	}

	public int getFrozen() {
		return frozen;
	}

	public void setFrozen(int frozen) {
		this.frozen = frozen;
	}
	
	@Override
	//重写toString方法显示客户信息
	public String toString() {
		return "\n客户号是:"+this.cuId+",客户姓名是:"+this.cuName+",客户会员类型是:"+this.memtype+",客户余额为:"+this.cubal;
	}
	
}
