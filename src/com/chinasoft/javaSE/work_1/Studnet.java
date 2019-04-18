package com.chinasoft.javaSE.work_1;

public class Studnet {
	private int id;
	private String name;
	private double score;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void show(){
		System.out.println(id+"\t"+name+"\t"+score);
	}
	public Studnet(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public Studnet() {
		super();
	}
	
	
}
