package com.chinasofti.restman.dmain;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class CustomerConsumptionRecords implements Serializable{
	private String orid;
	private String diname;
	private int dinum;
	private double disum;
	private Date ordate;
	private int cuid;
	private double totalprice;
	public CustomerConsumptionRecords(String orid, String diname, int dinum, Date ordate, int cuid,
			double totalprice) {
		super();
		this.orid = orid;
		this.diname = diname;
		this.dinum = dinum;
		this.ordate=ordate;
		this.cuid = cuid;
		this.totalprice = totalprice;
	}
	public CustomerConsumptionRecords() {
		super();
	}
	
	public String getOrid() {
		return orid;
	}
	public void setOrid(String orid) {
		this.orid = orid;
	}
	public String getDiname() {
		return diname;
	}
	public void setDiname(String diname) {
		this.diname = diname;
	}
	public int getDinum() {
		return dinum;
	}
	public void setDinum(int dinum) {
		this.dinum = dinum;
	}
	public double getDisum() {
		return disum;
	}
	public void setDisum(double disum) {
		this.disum = disum;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	public int getCuid() {
		return cuid;
	}
	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		
		return "订单号:"+this.orid+" 菜品名:"+this.diname+" 菜品数量:"+this.dinum+" "+this.diname+" 订单日期:"+this.ordate+" 客户号:"+this.cuid+" 订单总价:"+totalprice;
	}
}
