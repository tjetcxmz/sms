
package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Orderterm implements Serializable{
	private String orid;
	private int diid;
	private int dinum;
	private double price;
	
	public Orderterm(int diid, int dinum,double price) {
		super();
		this.diid = diid;
		this.dinum = dinum;
		this.price=price;
	}
	
	public Orderterm(String orid, int diid, int dinum,double price) {
		super();
		this.orid = orid;
		this.diid = diid;
		this.dinum = dinum;
		this.price=price;
	}

	public String getOrid() {
		return orid;
	}

	public void setOrid(String orid) {
		this.orid = orid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Orderterm() {
		super();
	}
	public int getDiid() {
		return diid;
	}
	public void setDiid(int diid) {
		this.diid = diid;
	}
	public int getDinum() {
		return dinum;
	}
	public void setDinum(int dinum) {
		this.dinum = dinum;
	}
	@Override
	public String toString() {
		return "订单号为   "+this.getOrid()+"\t菜品id是:   "+this.getDiid()+"\t菜品数量是:   "+this.getDinum()+"\t菜品价格是 :   "+this.getPrice();
	}
}
