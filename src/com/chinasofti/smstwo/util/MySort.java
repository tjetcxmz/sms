package com.chinasofti.smstwo.util;

import java.util.Comparator;

import com.chinasofti.smstwo.dmain.Student;

public class MySort implements Comparator<Student>{
	//true 升序  false 降序
	
	private boolean flag;
	
	public MySort(boolean flag){
		this.flag=flag;
	}
	
	@Override
	public int compare(Student o1, Student o2) {
		if(flag){
			if(o1.getStuScore()>o2.getStuScore()){
				return 1;
			}else if(o1.getStuScore()<o2.getStuScore()){
				return -1;
			}
		}else{
			if(o1.getStuScore()>o2.getStuScore()){
				return -1;
			}else if(o1.getStuScore()<o2.getStuScore()){
				return 1;
			}
		}
		return 0;
	}
	
}
