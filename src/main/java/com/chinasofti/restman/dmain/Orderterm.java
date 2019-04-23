package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Orderterm implements Serializable{
	private int diid;
	private int dinum;
	private double price;
	public Orderterm(int diid, int dinum,double price) {
		super();
		this.diid = diid;
		this.dinum = dinum;
		this.price=price;
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
	private void show() {
		System.out.println("菜品id是:"+this.getDiid()+"菜品数量是"+this.getDinum()+"菜品数量是"+this.getPrice());
	}
}
