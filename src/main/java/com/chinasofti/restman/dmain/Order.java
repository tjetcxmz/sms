package com.chinasofti.restman.dmain;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Order {
	private int orid;
	private String ordate;
	private int stid;
	private int cuid;
	public Order(int orid, String ordate, int stid, int cuid) {
		super();
		this.orid = orid;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ordate = sdf.format(new Date());
		this.stid = stid;
		this.cuid = cuid;
	}
	public Order() {
		super();
	}
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public String getOrdate() {
		return ordate;
	}
	public void setOrdate(String ordate) {
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
