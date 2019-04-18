package com.chinasofti.smstwo.dmain;

import java.io.Serializable;

public class Student implements Serializable{
	//属性
	private int stuId;
	private String stuName;
	private double stuScore;
	//构造方法
	public Student(int stuId, String stuName, double stuScore) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuScore = stuScore;
	}
	
	public Student() {
		
	}
	
	public int getStuId() {
		// TODO Auto-generated method stub
		return stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public double getStuScore() {
		return stuScore;
	}

	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}
	@Override
	public String toString() {
		return this.stuId+"\t"+this.stuName+"\t"+this.stuScore;
	}
	public String show(){
		return this.stuId+"#"+this.stuName+"#"+this.stuScore;
	}
}
