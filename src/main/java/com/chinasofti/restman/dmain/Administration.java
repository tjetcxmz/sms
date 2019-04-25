package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Administration implements Serializable{
	private int admId;
	private String admName;
	private String admPass;
	
	public Administration() {
		
	}
	
	public Administration( int admid,String admPass) {
		super();
		this.admId=admid;
		this.admPass = admPass;
	}
	
	
	public Administration(int admId, String admName, String admPass) {
		super();
		this.admId = admId;
		this.admName = admName;
		this.admPass = admPass;
	}

	public int getAdmId() {
		return admId;
	}
	public void setAdmId(int admId) {
		this.admId = admId;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPass() {
		return admPass;
	}
	public void setAdmPass(String admPass) {
		this.admPass = admPass;
	}
	
	@Override
	public String toString() {
		return "经理工号为:"+this.admId+"经理姓名为:"+this.admName;
	}
}
