package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Dishes implements Serializable {
	private int diid;
	private String diname;
	private double diprice;
	private int dtid;
	private int dimonsv;
	private int ischeap;

	public Dishes( int diid,String diname, double diprice, int dtid,int ischeap) {
		super();
		this.diid=diid;
		this.diname = diname;
		this.diprice = diprice;
		this.dtid = dtid;
		this.ischeap=ischeap;
	}
	public Dishes( String diname, double diprice, int dtid) {
		super();
		
		this.diname = diname;
		this.diprice = diprice;
		this.dtid = dtid;

		
	}
	public Dishes(int diid, String diname, double diprice, int dtid, int dimonsv, int ischeap) {
		super();
		this.diid = diid;
		this.diname = diname;
		this.diprice = diprice;
		this.dtid = dtid;
		this.dimonsv = dimonsv;
		this.ischeap = ischeap;
	}
	public Dishes( String diname, double diprice, int dtid,int ischeap) {
		super();
		this.diname = diname;
		this.diprice = diprice;
		this.dtid = dtid;
		this.ischeap=ischeap;
	}
	public Dishes() {
		super();
	}
	public int getDiid() {
		return diid;
	}
	public void setDiid(int diid) {
		this.diid = diid;
	}
	public String getDiname() {
		return diname;
	}
	public void setDiname(String diname) {
		this.diname = diname;
	}
	public double getDiprice() {
		return diprice;
	}
	public void setDiprice(double diprice) {
		this.diprice = diprice;
	}
	public int getDtid() {
		return dtid;
	}
	public void setDtid(int dtid) {
		this.dtid = dtid;
	}
	public int getDimonsv() {
		return dimonsv;
	}
	public void setDimonsv(int dimonsv) {
		this.dimonsv = dimonsv;
	}
	
	public int getIscheap() {
		return ischeap;
	}
	public void setIscheap(int ischeap) {
		this.ischeap = ischeap;
	}

	@Override
	public String toString() {
		
		return "\n菜品号:"+this.diid+",菜品名:"+this.diname+",价格:"+this.diprice+",菜品类型:"+this.dtid+",月销量:"+this.dimonsv;
	}
}
