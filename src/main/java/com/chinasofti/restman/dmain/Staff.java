package com.chinasofti.restman.dmain;

import java.io.Serializable;

//员工类
public class Staff implements Serializable{
	//员工号
	private int stId;
	//员工姓名
	private String stName;
	//员工密码
	private String stPass;
	
	public Staff() {
		
	}
	
	public Staff(int stId, String stPass) {
		super();
		this.stId = stId;
		this.stPass = stPass;
	}

	public Staff(int stId, String stName, String stPass) {
		super();
		this.stId = stId;
		this.stName = stName;
		this.stPass = stPass;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStPass() {
		return stPass;
	}

	public void setStPass(String stPass) {
		this.stPass = stPass;
	}
	
	@Override
	public String toString() {
		return "员工号为:"+this.stId+"员工姓名为:"+this.stName;
	}
	
}
