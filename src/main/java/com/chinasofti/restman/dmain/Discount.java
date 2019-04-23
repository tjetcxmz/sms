package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Discount implements Serializable{
	//非会员
	private double commonDis;
	//普通会员
	private double memberDis;
	//超级会员
	private double superDis;

	public Discount() {
		super();
		this.commonDis=1;
		this.memberDis=0.9;
		this.superDis=0.75;
	}
	public void Discount(double memberDis, double superDis) {
		this.memberDis = memberDis;
		this.superDis = superDis;
	}
	public double getCommonDis() {
		return commonDis;
	}
	public void setCommonDis(double commonDis) {
		this.commonDis = commonDis;
	}
	public double getMemberDis() {
		return memberDis;
	}
	public void setMemberDis(double memberDis) {
		this.memberDis = memberDis;
	}
	public double getSuperDis() {
		return superDis;
	}
	public void setSuperDis(double superDis) {
		this.superDis = superDis;
	}
	//根据会员类型返回优惠额度
	public double show(int memtype) {
		if (memtype==1) {
			return this.getMemberDis();
		}else if (memtype==2) {
			return this.getSuperDis();
		}else {
			return 1;
		}

	}
}
