package com.chinasofti.restman.dmain;

import java.io.Serializable;

public class Discount implements Serializable{
	//非会员
	private double commonDis;
	//普通会员
	private double memberDis;
	//超级会员
	private double superDis;
	//普通会员的优惠额度
	private  double commonEdu=0.9;
	//超级会员的额度
	private  double superEdu=0.75;
	
	public Discount() {
		super();
		this.commonDis=1;
		this.memberDis=commonEdu;
		this.superDis=superEdu;
	}
	public  double getCommonEdu() {
		return commonEdu;
	}
	
	public double getSuperEdu() {
		return superEdu;
	}
	public void setSuperEdu(double superEdu) {
		this.superEdu = superEdu;
	}
	public void setCommonEdu(double commonEdu) {
		this.commonEdu = commonEdu;
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
